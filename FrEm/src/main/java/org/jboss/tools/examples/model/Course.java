package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Course implements Serializable {
 
    
 
    @Id
    @GeneratedValue
    private Long id;
    
    
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Given coursename must not contain numbers")
    private String courseName;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Given course price has to be numbers")
    private int coursePrice;	
    
    

//    @NotNull
//    @Inject
//    private DefinedDate startDate;
//    
//    
// 
//    @NotNull
//    @Inject
//    private DefinedDate endDate;
    
        
    
    @NotNull
    @Size(min = 1, max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9_]*", message = "Given description can only contain alphanumeric charachters, (a-zA-Z0-9_)")
    private String courseDescr;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Number of participants at the course, must be a number.")
    private int numParticipants;


	
    
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCoursePrice() {
		return coursePrice;
	}


	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}


//	public DefinedDate getStartDate() {
//		return startDate;
//	}
//
//
//	public void setStartDate(DefinedDate startDate) {
//		this.startDate = startDate;
//	}
//
//
//	public DefinedDate getEndDate() {
//		return endDate;
//	}
//
//
//	public void setEndDate(DefinedDate endDate) {
//		this.endDate = endDate;
//	}


	public String getCourseDescr() {
		return courseDescr;
	}


	public void setCourseDescr(String courseDescr) {
		this.courseDescr = courseDescr;
	}


	public int getNumParticipants() {
		return numParticipants;
	}


	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
	}	
    
    
    
    
    
}
