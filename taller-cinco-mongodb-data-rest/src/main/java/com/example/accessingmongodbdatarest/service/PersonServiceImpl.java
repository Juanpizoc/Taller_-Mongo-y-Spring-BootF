package com.example.accessingmongodbdatarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingmongodbdatarest.dao.PersonRepository;
import com.example.accessingmongodbdatarest.document.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository dao;	
	
	@Override
	public Person updateCellNumber(Person person) {
		Optional<Person> objPerson = dao.findById(person.getId());
		Person personBd = new Person();
		
		if(objPerson.isPresent()) {
			
			personBd = objPerson.get();
			personBd.setCellNumber(person.getCellNumber());
			dao.delete(personBd);
			dao.save(personBd);
			
		}
		return personBd ;
	}
	
	@Override
	public Person save(Person person) {
		
			return dao.save(person);
		
	}

	@Override
	public List<Person> findAll() {
	    return dao.findAll();
	}

	@Override
	public List<Person> findAllConNombreUpperCase() {
	    return dao.findAll()
	              .stream()
	              .filter(person -> person.getFirstName().equals(person.getFirstName().toUpperCase()))
	              .toList();
	}

	@Override
	public List<Person> findAllConNombreUpperCaseRepeat() {
	    return dao.findAll()
	              .stream()
	              .filter(person -> {
	                  String[] names = person.getFirstName().split(" ");
	                  return names.length > 1 && names[0].equals(names[1]) && names[0].equals(names[0].toUpperCase());
	              })
	              .toList();
	}


	@Override
	public Person findById(String id) {
	    return dao.findById(id).orElse(null);
	}

	@Override
	public boolean delete(Person person) {
	    if (dao.existsById(person.getId())) {
	        dao.delete(person);
	        return true;
	    }
	    return false;
	}

	@Override
	public Person updateAddress(Person person) {
	    Optional<Person> objPerson = dao.findById(person.getId());
	    if (objPerson.isPresent()) {
	        Person personBd = objPerson.get();
	        personBd.setAddress(person.getAddress());
	        dao.save(personBd);
	        return personBd;
	    }
	    return null;
	}

	@Override
	public Person updateEmailAddress(Person person) {
	    Optional<Person> objPerson = dao.findById(person.getId());
	    if (objPerson.isPresent()) {
	        Person personBd = objPerson.get();
	        personBd.setEmailAddress(person.getEmailAddress());
	        dao.save(personBd);
	        return personBd;
	    }
	    return null;
	}

	
}
