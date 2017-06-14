package org.jboss.tools.examples.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.tools.examples.model.Course;

@RequestScoped
public class CourseListProducer {
	  @Inject
	    private CourseRepository courseRepository;

	    private List<Course> courses; 

	    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.
	    // Facelets or JSP view)    
	    @Produces
	    @Named
	    public List<Course> getCourses() {
	        return courses;
	    }

	    public void onCourseListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Course course) {
	    	retrieveAllCoursesOrderedByName();
	    }

	    @PostConstruct
	    public void retrieveAllCoursesOrderedByName() {
	        courses = courseRepository.findAllOrderedByName();
	    }
}
