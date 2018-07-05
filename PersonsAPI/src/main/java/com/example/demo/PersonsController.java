package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsController {
	
	private static List<Person> persons = new ArrayList<Person>();

	@PostConstruct
	private void init() {
		persons.add(new Person("Klaus", 40));
		persons.add(new Person("Rüdiger", 37));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/persons", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersons() {
		return persons;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/persons", 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> addPerson(Person person) {
		persons.add(person);
		
		return persons;
	}
	
}
