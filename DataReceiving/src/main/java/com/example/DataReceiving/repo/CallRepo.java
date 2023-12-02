package com.example.DataReceiving.repo;

import org.springframework.data.repository.*;

import com.example.DataReceiving.model.PersonsNumbers;

public interface CallRepo extends CrudRepository <PersonsNumbers, Long>{

	PersonsNumbers findByPhNumber(long phoneNumber);
	
}
