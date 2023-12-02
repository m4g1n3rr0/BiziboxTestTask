package com.example.DataReceiving.service;

import java.util.List;

import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.DataReceiving.exceptions.PhoneCallNotFoundException;
import com.example.DataReceiving.exceptions.PhoneInfoAlreadyExists;
import com.example.DataReceiving.model.Contact;
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
	
	
	public PersonsNumbers getOne(String phoneNumber) throws PhoneCallNotFoundException {
       
		PersonsNumbers preson = callRepo.findById(phoneNumber).orElse(null);
       
		if (preson == null) {
       
			throw new PhoneCallNotFoundException("User not found");
       
		}
       
		return preson;
    
	}

	
	public PersonsNumbers getMany(String phoneNumber) throws PhoneCallNotFoundException {
        
		PersonsNumbers preson = callRepo.findById(phoneNumber).orElse(null);
       
		if (preson == null) {
       
			throw new PhoneCallNotFoundException("User not found");
       
		}
       
		return preson;
    
	}

    public String delete(String phoneNumber) {
       
    	callRepo.deleteById(phoneNumber);
		return phoneNumber;
    
    }
    
    
	public List<PersonsNumbers> findByTalkDurationGreaterThan(String duration) throws PhoneCallNotFoundException {
    	
    	List<PersonsNumbers> persons = callRepo.findByTalkDurationGreaterThan(duration);
    	
    	if (persons.isEmpty()) {
            
    		throw new PhoneCallNotFoundException("Users not found");
       
    	}
    	
    	return persons;
   
    }
	
	public void addCall(Call call) {
        
		Call person = call.getPerson();

        if (person != null && !person.isBlacklist()) {
            callRepo.save(call);
        }
    
	}
    
}
