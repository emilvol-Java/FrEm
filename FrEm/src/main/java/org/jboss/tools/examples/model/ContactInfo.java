package org.jboss.tools.examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "contactInfoId"))
public class ContactInfo {

	@Id
    @GeneratedValue
	private int contactInfoId;
	
	@NotNull
    @Size(min = 1, max = 35)
	private String street="";
	
	@NotNull
    @Size(min = 5, max = 6)
    @Digits(fraction = 0, integer = 6)
	private int zipCode;
	
	@NotNull
    @Size(min = 1, max = 35)
    @Pattern(regexp = "[^0-9]*", message = "Given adress must not contain numbers")
	private String postAdress;
		
	
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
    private String phoneNumber;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getPostAdress() {
		return postAdress;
	}

	public void setPostAdress(String postAdress) {
		this.postAdress = postAdress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getContactInfoId() {
		return contactInfoId;
	}
    
    
}
