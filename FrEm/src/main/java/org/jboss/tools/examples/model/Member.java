/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.tools.examples.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member implements Serializable {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    private List<Course> courseEnlisted;
    
    @Named
    @OneToMany
    private List<Dog> dogList;
    
  

	@NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Given name must not contain numbers")
    @Column(name="fName")
    private String fName;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Surname must not contain numbers")
    @Column(name="sName")
    private String sName;


	@NotNull
    @NotEmpty
    @Email
    @Column(name="email")
    private String email;
	
	 @NotNull
	 @Size(min = 1, max = 25)
	 @Column(name="password")
	 private String passWord;
	 

		@NotNull
	    @Size(min = 6, max = 12)
	    @Digits(fraction = 0, integer = 12)
	    @Column(name = "phone_number")
	    private String phoneNumber;
	 
	    @NotNull
	    @Column(name="startDate")
	    private String startDate;
	 
	    public List<Dog> getDogList() {
			return dogList;
		}

		@Override
		public String toString() {
			String list="";
			for(Dog d:dogList){
				list = list + " "+d.getName();
			}
			return "Member [dogList=" + list + "]";
		}

		public void setDogList(List<Dog> dogList) {
			this.dogList = dogList;
		}
		
	public void addDogToList(Dog doggy){
		dogList.add(doggy);
	}
//	@Inject 
//	DogRepository dogrepo;
//	
//    public void retrieveAllDogsByEmail() {
//        dogList = dogrepo.findAllOrderedByName();
//        for(Dog dd:dogList){
//        	if(!dd.getOwner().equals(this.email)){
//        		dogList.remove(dd);
//        	}
//        }
//    }
	
	public void removeDogFromList(Dog doggy){
		
	}
			 	 
    public String getPassWord() {
		return passWord;
	}
        
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setStartDate(DefinedDate startDate) {
		this.startDate = startDate.getDate();
	}

    

    
    public Member(){
    }

	public String getStartDate() {
		return startDate.toString();
	}


    public Long getId() {
        return id;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    
    public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

    public String getEmail() {
    	return this.email;
        //return details.getEmail();
    }

    public void setEmail(String email) {
    	this.email = email;
    	//details.setEmail(email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void enlistToCourse(Course c){
    	courseEnlisted.add(c);
    }
}
