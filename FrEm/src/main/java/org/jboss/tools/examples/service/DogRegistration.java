package org.jboss.tools.examples.service;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Member;

public class DogRegistration {
    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<dog> memberEventSrc;

    public void register(Dog dog) throws Exception {
        log.info("Registering " + dog.getName()+ " " + dog.getRace());
        em.persist(dog);
        memberEventSrc.fire(dog);
    }
}
