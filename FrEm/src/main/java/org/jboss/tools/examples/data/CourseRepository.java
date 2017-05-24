package org.jboss.tools.examples.data;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.examples.model.Course;

public class CourseRepository {
	  @Inject
	    private EntityManager em;

	    public Course findById(Long id) {
	        return em.find(Course.class, id);
	    }
	    	
//

	    public List<Course> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Course> criteria = cb.createQuery(Course.class);
	        Root<Course> course = criteria.from(Course.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
	        criteria.select(course).orderBy(cb.asc(course.get("cName")));
	        return em.createQuery(criteria).getResultList();
	    }
}
