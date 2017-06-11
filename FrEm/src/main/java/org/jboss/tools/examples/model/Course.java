package org.jboss.tools.examples.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Course implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    private List<Member> coursemembers;
    
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name="COURSENAME")
    private String courseName;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Given course price has to be numbers")
    private int coursePrice;	
    
    @NotNull
    @Column(name="STARTDATE")
    private String startDate;
    
    @NotNull
    @Column(name="ENDDATE")
    private String endDate;
    

	@NotNull
    @Size(min = 1, max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9_]*", message = "Given description can only contain alphanumeric charachters, (a-zA-Z0-9_)")
	@Column(name="COURSEDESRCIPTION")
    private String courseDescr;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name="MAXPARTICIPANTS")
    private int numParticipants;
    
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name="PARTICIPANTS")
    private int participants=0;
    

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public String getStartDate() {
		return startDate.toString();
	}

	public void setStartDate(String start) {
		DefinedDate def = new DefinedDate(start);
		startDate = def.getDate();
	}
	
	public String getEndDate() {
		return endDate.toString();
	}

	public void setEndDate(String start) {
		DefinedDate def = new DefinedDate(start);
		endDate = def.getDate();
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
	
	public void addmemberToCourse(Member mem){
		coursemembers.add(mem);
	}
	
	public void removeMemberFromList(Member mem){
		for(Member m:coursemembers){
			if(m.getEmail().equals(mem.getEmail()))
				coursemembers.remove(mem);
		}
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
