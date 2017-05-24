package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
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
    
    

    @NotNull
    private DefinedDate startDate;
    
    
 
    @NotNull
    private DefinedDate endDate;
    
       
    
    
    
    @NotNull
    @Size(min = 1, max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9_]*", message = "Given description can only contain alphanumeric charachters, (a-zA-Z0-9_)")
    private String courseDescr;

    
    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Number of participants at the course, must be a number.")
    private int numParticipants;	
    
    
    
    
    
}
