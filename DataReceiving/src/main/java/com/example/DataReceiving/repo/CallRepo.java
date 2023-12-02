package com.example.DataReceiving.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

import com.example.DataReceiving.model.PersonsNumbers;

public interface CallRepo extends JpaRepository<PersonsNumbers, String> {
    
	PersonsNumbers findByPhoneNumber(String string);

}
