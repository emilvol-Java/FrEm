package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.component.html.*;
import javax.inject.Inject;

import org.jboss.tools.examples.controller.MemberController;
import org.jboss.tools.examples.data.MemberRepository;




@ManagedBean
@SessionScoped
public class Login implements Serializable {


	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Inject 
	MemberController memberControl;
	
	//validate login
	public String validateUsernamePassword() {
		
		
		boolean valid = memberControl.validate(user, pwd);
		if (valid) {
			
			return "success"; 
		} else {		
			return "failure";
		}
	}

	//logout event, invalidate session
//	public String logout() {
//		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		session.invalidate();
//		return "login";
//	}
}
