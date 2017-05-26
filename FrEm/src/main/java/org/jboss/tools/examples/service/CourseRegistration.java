package org.jboss.tools.examples.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Course;

@Stateless
public class CourseRegistration {
	   @Inject
	    private Logger log;

	    @Inject
	    private EntityManager em;

	    @Inject
	    private Event<Course> courseEventSrc;

	    public void register(Course course) throws Exception {
	        log.info("Registering " + course.getCourseName()+ " "+course.getId());
	        em.persist(course);
	        courseEventSrc.fire(course);
	    }
	    //   
}
