package com.example.DataReceiving.model;

import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "PhoneBook")
public class PersonsNumbers {
	
	@Id
	private String phoneNumber;
	private String time;
	private String callType;
	private String duration;
	
	public PersonsNumbers() {}
	
	public String getPhoneNumber() {
		
		return phoneNumber;
	
	}
	
	public String getTime() {
	
		return time;
	
	}
	
	public void setTime(String time) {
	
		this.time = time;
	
	}
	
	public String getCallTypet() {
	
		return callType;
	
	}
	
	public void setIncOut(String incOut) {
	
		this.callType = incOut;
	
	}
	
	public String getDuration() {
	
		return duration;
	
	}
	
	public void setDuration(String duration) {
	
		this.duration = duration;
	
	}
	

}
