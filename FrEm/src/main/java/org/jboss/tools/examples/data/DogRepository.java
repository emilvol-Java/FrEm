package org.jboss.tools.examples.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.examples.model.Dog;

@ApplicationScoped
public class DogRepository {
	  @Inject
	    private EntityManager em;

	    public Dog findById(Long id) {
	        return em.find(Dog.class, id);
	        
	    }
	    	
//  

	    public List<Dog> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Dog> criteria = cb.createQuery(Dog.class);
	        Root<Dog> dog = criteria.from(Dog.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new 
	        // feature in JPA 2.0
	        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
	        criteria.select(dog).orderBy(cb.asc(dog.get("name")));
	        return em.createQuery(criteria).getResultList();
	    }
}
