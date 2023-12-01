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

}
