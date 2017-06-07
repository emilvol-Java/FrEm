package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.Email;
import org.jboss.tools.examples.controller.MemberController;
import org.jboss.tools.examples.util.SessionUtils;





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
		System.out.println("[validateUsernamePassword] : userEmail :"+useremail+" PWD: "+pwd);
		boolean valid = memberControl.validate(useremail, pwd);
		if (valid) {		
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
			return "logout";
		}
	
}
