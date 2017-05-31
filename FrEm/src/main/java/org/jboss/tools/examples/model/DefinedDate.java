package org.jboss.tools.examples.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlRootElement;


@Named
@XmlRootElement
public class DefinedDate implements Serializable{
	
	private String date;

	public DefinedDate(){
		setPresentDate();
	}
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date);
		System.out.println("Set date :"+dtf.format(localDate)); //2016-11-16		
		this.date = dtf.format(localDate);
	}
	
	
	public void setPresentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016-11-16		
		this.date = dtf.format(localDate);
	}
	
	@Override
	public String toString() {
		return date;
	}
	
	
	
	
}
