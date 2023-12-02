package com.example.DataReceiving.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Call {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Contact person;

	public Long getId() {
		
		return id;
	
	}

	public void setId(Long id) {
	
		this.id = id;
	
	}

	public Contact getPerson() {
	
		return person;
	
	}

	public void setPerson(Contact person) {
	
		this.person = person;
	
	}
	
    
    
}
