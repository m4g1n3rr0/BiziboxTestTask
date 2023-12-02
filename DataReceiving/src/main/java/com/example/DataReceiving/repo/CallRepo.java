package com.example.DataReceiving.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DataReceiving.model.PersonsNumbers;

public interface CallRepo extends JpaRepository<PersonsNumbers, String> {
    
	PersonsNumbers findByPhoneNumber(String string);
	
	 List<PersonsNumbers> findByTalkDurationGreaterThan(String string);

}
