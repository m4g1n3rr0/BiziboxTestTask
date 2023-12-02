package com.example.DataReceiving.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.DataReceiving.exceptions.PhoneInfoAlreadyExists;
import com.example.DataReceiving.model.PersonsNumbers;
import com.example.DataReceiving.service.PhNumService;

@RestController
@RequestMapping("/PhoneBook")
public class Controller {
	
	@Autowired 
	private PhNumService phNum;
	
	@PostMapping
	public ResponseEntity registration(@RequestBody PersonsNumbers phoneNumber) {
	
		try {
			
			phNum.registration(phoneNumber);
			return ResponseEntity.ok("Information aboutИ call was successfully saved");
			
		} catch (PhoneInfoAlreadyExists e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error was happened");
			
		}
		
	}
	
	@GetMapping("/user")
	public ResponseEntity getOneUser(@RequestParam String PhoneNumber) {
	
		try {
			
			phNum.getOne(PhoneNumber);
			return ResponseEntity.ok("Server is working");
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error was happened");
			
		}
	
	}
	
	@GetMapping
	public ResponseEntity getUsers(@RequestParam String PhoneNumber) {
	
		try {
			
			phNum.getMany(PhoneNumber);
			return ResponseEntity.ok("Server is working");
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error was happened");
			
		}
		
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String PhoneNumber) {
       
		try {
            
        	phNum.delete(PhoneNumber);
        	return ResponseEntity.ok(phNum.delete(PhoneNumber));
       
        } catch (Exception e) {
         
        	return ResponseEntity.badRequest().body("Error was happened");
        
        }
    
	}
	
}
