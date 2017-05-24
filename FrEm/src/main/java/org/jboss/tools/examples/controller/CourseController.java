package org.jboss.tools.examples.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.tools.examples.model.Course;
import org.jboss.tools.examples.service.CourseRegistration;

public class CourseController {
	  @Inject
	    private FacesContext facesContext;

	    @Inject
	    private CourseRegistration dogRegistration;

	    @Produces
	    @Named
	    private Course newCourse;

	    @PostConstruct
	    public void initNewMember() {
	        newCourse = new Course();
	    }

	    public void register() throws Exception {
	        try {
	            dogRegistration.register(newCourse);
	            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
	            facesContext.addMessage(null, m);
	            initNewMember();
	        } catch (Exception e) {
	            String errorMessage = getRootErrorMessage(e);
	            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
	            facesContext.addMessage(null, m);
	        }
	    }

	    private String getRootErrorMessage(Exception e) {
	        // Default to general error message that registration failed.    
	        String errorMessage = "Registration failed. See server log for more information";
	        if (e == null) {
	            // This shouldn't happen, but return the default messages
	            return errorMessage;
	        }

	        // Start with the exception and recurse to find the root cause
	        Throwable t = e;
	        while (t != null) {
	            // Get the message from the Throwable class instance
	            errorMessage = t.getLocalizedMessage();
	            t = t.getCause();
	        }
	        // This is the root cause message
	        return errorMessage;
	    }
}
