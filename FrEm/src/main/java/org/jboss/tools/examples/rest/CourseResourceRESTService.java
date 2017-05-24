package org.jboss.tools.examples.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.data.CourseRepository;
import org.jboss.tools.examples.model.Course;
import org.jboss.tools.examples.service.CourseRegistration;

public class CourseResourceRESTService {
	 @Inject
	    private Logger log;



	    @Inject
	    private CourseRepository repository;

	    @Inject
	    CourseRegistration registration;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Course> listAllCourses() {
	        return repository.findAllOrderedByName();
	    }

	    @GET
	    @Path("/{id:[0-9][0-9]*}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Course lookupCourseById(@PathParam("id") long id) {
	        Course course = repository.findById(id);
	        if (course == null) {
	            throw new WebApplicationException(Response.Status.NOT_FOUND);
	        }
	        return course;
	    }

	    /**
	     * Creates a new member from the values provided. Performs validation, and will return a JAX-RS response with either 200 ok,
	     * or with a map of fields, and related errors.    
	     */
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createCourse(Course course) {

	        Response.ResponseBuilder builder = null;

	        try {
	            registration.register(course);
	            // Create an "ok" response
	            builder = Response.ok();

	        } catch (Exception e) {
	            // Handle generic exceptions
	            Map<String, String> responseObj = new HashMap<>();
	            responseObj.put("error", e.getMessage());
	            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	        }

	        return builder.build();
	    }


}
