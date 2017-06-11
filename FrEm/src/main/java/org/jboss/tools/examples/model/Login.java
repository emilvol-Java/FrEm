package org.jboss.tools.examples.model;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.Email;
import org.jboss.tools.examples.controller.MemberController;
import org.jboss.tools.examples.util.SessionUtils;





@ManagedBean
public class Login {


	@Named
	private String pwd="";
	
	@Named
	@Email
	private String useremail="";
	
	
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
			System.out.println("[validateUsernamePassword] : sucess");
			return "success"; 
		} else {

			System.out.println("[validateUsernamePassword] : failure");
			return "failure";
		}
	}
	
	//logout event, invalidate session
		public void logout() throws Throwable{	
//			memberControl.killSession();
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	   		 ec.invalidateSession();
	   		 ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
			 System.out.println("Logout gjort......" +memberControl.getMemberName());
//			return "logout";
		}
	
}
