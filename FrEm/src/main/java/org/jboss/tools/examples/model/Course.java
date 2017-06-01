package org.jboss.tools.examples.model;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
//@XmlRootElement
public class Course implements Serializable {
 
    @Id
    @GeneratedValue
    private Long id;
    
    
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name="COURSENAME")
    private String courseName;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Given course price has to be numbers")
    private int coursePrice;	
    
    @Inject
    private DefinedDate startDate;
    
    @Inject
    private DefinedDate endDate;
    

	@NotNull
    @Size(min = 1, max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9_]*", message = "Given description can only contain alphanumeric charachters, (a-zA-Z0-9_)")
    private String courseDescr;

    
    @NotNull
    @Size(min = 1, max = 4)
    private int numParticipants;
    
    
    

	public String getStartDate() {
		return startDate.toString();
	}

	public void setStartDate(String start) {
		startDate.setDate(start);;
	}
	
	public String getEndDate() {
		return endDate.toString();
	}

	public void setEndDate(String start) {
		endDate.setDate(start);;
	}

    
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
