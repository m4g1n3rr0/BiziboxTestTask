package com.example.DataReceiving.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.DataReceiving.exceptions.PhoneCallNotFoundException;
import com.example.DataReceiving.exceptions.PhoneInfoAlreadyExists;
import com.example.DataReceiving.model.PersonsNumbers;
import com.example.DataReceiving.repo.CallRepo;

@Service
public class PhNumService {
	
	@Autowired 
	CallRepo callRepo;
	
	public PersonsNumbers registration(PersonsNumbers phoneNumber) throws PhoneInfoAlreadyExists {
      
		if (callRepo.findByPhoneNumber(phoneNumber.getPhoneNumber()) != null) {
      
			throw new PhoneInfoAlreadyExists("Info about this call is already exists");
    
        }
    
        return callRepo.save(phoneNumber);
    
	}
	
	
	public PersonsNumbers getOne(Long phoneNumber) throws PhoneCallNotFoundException {
       
		PersonsNumbers user = callRepo.findById(phoneNumber).orElse(null);
       
		if (user == null) {
       
			throw new PhoneCallNotFoundException("User not found");
       
		}
       
		return user;
    
	}

	
	public PersonsNumbers getMany(Long phoneNumber) throws PhoneCallNotFoundException {
        
		PersonsNumbers user = callRepo.findById(phoneNumber).orElse(null);
       
		if (user == null) {
       
			throw new PhoneCallNotFoundException("User not found");
       
		}
       
		return user;
    
	}

    /*public Long delete(Long phoneNumber) {
        CallRepo.deleteByPhoneNumber(phoneNumber);
        return phoneNumber;
    }*/
    
}
