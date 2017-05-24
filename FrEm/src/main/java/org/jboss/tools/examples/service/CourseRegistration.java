package org.jboss.tools.examples.service;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Course;

public class CourseRegistration {
	   @Inject
	    private Logger log;

	    @Inject
	    private EntityManager em;

	    @Inject
	    private Event<Course> memberEventSrc;

	    public void register(Course course) throws Exception {
	        log.info("Registering " + course.getName()+ " " + course.getBreed());
	        em.persist(course);
	        memberEventSrc.fire(course);
	    }
	    //  
}
