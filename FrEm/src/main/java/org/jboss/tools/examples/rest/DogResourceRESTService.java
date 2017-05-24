package org.jboss.tools.examples.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.data.DogRepository;
import org.jboss.tools.examples.data.MemberRepository;
import org.jboss.tools.examples.model.Dog;
import org.jboss.tools.examples.model.Member;
import org.jboss.tools.examples.service.DogRegistration;
import org.jboss.tools.examples.service.MemberRegistration;

public class DogResourceRESTService {

    @Inject
    private Logger log;



    @Inject
    private DogRepository repository;

    @Inject
    DogRegistration registration;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dog> listAllDogs() {
        return repository.findAllOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dog lookupDogById(@PathParam("id") long id) {
        Dog dog = repository.findById(id);
        if (dog == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return dog;
    }

    /**
     * Creates a new member from the values provided. Performs validation, and will return a JAX-RS response with either 200 ok,
     * or with a map of fields, and related errors.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDog(Dog dog) {

        Response.ResponseBuilder builder = null;

        try {
            registration.register(dog);
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
