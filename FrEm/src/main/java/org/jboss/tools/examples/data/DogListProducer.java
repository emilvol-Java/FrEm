package org.jboss.tools.examples.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.tools.examples.controller.MemberController;
import org.jboss.tools.examples.model.Dog;

@RequestScoped
public class DogListProducer {

    @Inject
    private DogRepository dogRepository;

    private List<Dog> dogs;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g. 
    // Facelets or JSP view)   
    @Produces
    @Named
    public List<Dog> getDogs() {
        return dogs;
    }
    public List<Dog> getDogsByOwner(String email){
    	List<Dog> tmp = new ArrayList();
    	for(Dog doggy:dogs){
    		if(doggy.getOwner().equals(email))
    			tmp.add(doggy);
    	}
    	return tmp;
    }

    public void onDogDogChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Dog dog) {
        retrieveAllDogsOrderedByName();
    }

    @PostConstruct
    public void retrieveAllDogsOrderedByName() {
        dogs = dogRepository.findAllOrderedByName();
    }
}
