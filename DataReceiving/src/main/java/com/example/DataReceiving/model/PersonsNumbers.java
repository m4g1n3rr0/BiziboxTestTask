package com.example.DataReceiving.model;

import lombok.Data;
import org.springframework.*;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "PhoneBook")
public class PersonsNumbers {
	
	@Id
	private long phoneNumber;
	private String time;
	private String incOut;
	private String duration;
	
	public PersonsNumbers() {}
	
	public long getPhoneNumber() {
		
		return phoneNumber;
	
	}
	
	public String getTime() {
	
		return time;
	
	}
	
	public void setTime(String time) {
	
		this.time = time;
	
	}
	
	public String getIncOut() {
	
		return incOut;
	
	}
	
	public void setIncOut(String incOut) {
	
		this.incOut = incOut;
	
	}
	
	public String getDuration() {
	
		return duration;
	
	}
	
	public void setDuration(String duration) {
	
		this.duration = duration;
	
	}
	

}
