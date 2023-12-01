package com.example.DataReceiving.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.DataReceiving.model.PersonsNumbers;
import com.example.DataReceiving.repo.CallRepo;

@RestController
@RequestMapping("/PhineBook")
public class Controller {
	
	@Autowired
	private CallRepo callRepo;
	
	@PostMapping
	public ResponseEntity registration(@RequestBody PersonsNumbers phoneNumber) {
	
		try {
			
			callRepo.save(phoneNumber);
			return ResponseEntity.ok("Information aboutИ call was successfully saved");
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error was happened");
			
		}
		
	}
	
	@GetMapping
	public ResponseEntity getUsers() {
	
		try {
			
			return ResponseEntity.ok("Server is working");
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error was happened");
			
		}
		
	}
	
}
