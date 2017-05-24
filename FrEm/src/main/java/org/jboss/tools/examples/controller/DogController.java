package org.jboss.tools.examples.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.tools.examples.model.Dog;
import org.jboss.tools.examples.service.DogRegistration;
import org.jboss.tools.examples.service.MemberRegistration;

public class DogController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private DogRegistration dogRegistration;

    @Produces
    @Named
    private Dog newDog;

    @PostConstruct
    public void initNewMember() {
        newDog = new Dog();
    }

    public void register() throws Exception {
        try {
            dogRegistration.register(newDog);
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
