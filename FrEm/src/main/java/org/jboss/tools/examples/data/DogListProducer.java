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
    
    
//    @RequestScoped
//    public void setDogsByOwner(String mail) {
//    	for(Dog d:dogs){
//    		if(d.getOwner().equals(mail))
//    			dogsByOwner.add(d);
//    	}
//    }
    @Produces
    @Named
    public List<Dog> getDogsByOwner(String owner) {
    	List<Dog> doglist = new ArrayList<Dog>();
    	for(Dog d:dogs){
    		if(d.getOwner().equals(owner))
    			doglist.add(d);
    	}
        return doglist;
    }

    public void onDogDogChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Dog dog) {
    	System.out.println("[onDogDogChanged] ???????????????");
        retrieveAllDogsOrderedByName();
    }

    @PostConstruct
    public void retrieveAllDogsOrderedByName() {
    	System.out.println("[retrieveAllDogsOrderedByName] ???????????????");
        dogs = dogRepository.findAllOrderedByName();
//        dogsByOwner = dogRepository.findAllDogsByOwner(this.dog.getOwner());
    }
    
    
//    public void retrieveAllDogsByOwner(String email) {
//    	System.out.println("[retrieveAllDogsByOwner] ?????????????????");
//        dogsByOwner = dogRepository.findAllDogsByOwner(email);
//    }
}
