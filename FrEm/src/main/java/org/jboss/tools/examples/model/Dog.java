package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement 
public class Dog implements Serializable {

	
    @Id
    @GeneratedValue
    private Long id;


    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Given name must not contain numbers")
    private String breed;
    
    
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Given name must not contain numbers")
    private String dogname;
    
    
    @NotNull
    @Size(min = 2, max = 4)
    @Pattern(regexp = "[0-9]*", message = "Given field is the year the dog was born, has to be numbers")
    private int born;
    
    @NotNull
    private boolean vaccinated;


	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return dogname;
	}

	public void setName(String name) {
		this.dogname = name;
	}

	public int getBorn() {
		return born;
	}

	public void setBorn(int born) {
		this.born = born;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public Long getId() {
		return id;
	}
    
    //
    
    
    
}
