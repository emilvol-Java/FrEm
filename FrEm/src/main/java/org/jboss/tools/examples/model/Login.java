package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.component.html.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.jboss.tools.examples.controller.MemberController;
import org.jboss.tools.examples.data.MemberRepository;




@ManagedBean
@SessionScoped
public class Login implements Serializable {


	@Named
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Named
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[A-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email must be a valid email")
	private String useremail;
	


	@Inject 
	MemberController memberControl;
	
	//validate login
	public String validateUsernamePassword() {
		
		
		boolean valid = memberControl.validate(useremail, pwd);
		if (valid) {
			
			HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("username", useremail);
			
			return "success"; 
				
		} else {
			FacesContext.getCurrentInstance().addMessage(
			null,
			new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd",
					"Please enter correct username and Password"));
			return "failure";
		}
	}
	
}
