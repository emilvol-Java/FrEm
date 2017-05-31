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

import utils.SessionUtils;





@ManagedBean
@SessionScoped
public class Login implements Serializable {


	private static final long serialVersionUID = 6075044697570830467L;

	@Named
	private String pwd;
	
	@Named
	@Email
	private String useremail;
	
	
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

	
	

	@Inject 
	MemberController memberControl;
	
	//validate login
	public String validateUsernamePassword() {
		
		
		boolean valid = memberControl.validate(useremail, pwd);
		if (valid) {
			
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", useremail);
//			session.setAttribute("userid", fixa ut userid:t här på nåt sätt...     );
			
			return "success"; 
				
		} else {
//			FacesContext.getCurrentInstance().addMessage(
//			null,
//			new FacesMessage(FacesMessage.SEVERITY_WARN,
//					"Incorrect Username and Password",
//					"Please enter correct username and Password"));
			
			return "failure";
		}
	}
	
	//logout event, invalidate session
		public String logout() {
			HttpSession session = SessionUtils.getSession();
			session.invalidate();
			return "failure";
		}
	
}
