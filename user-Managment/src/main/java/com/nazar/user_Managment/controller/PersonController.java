package com.nazar.user_Managment.controller;		
import java.util.List;

import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nazar.user_Managment.entity.Person;
import com.nazar.user_Managment.repository.PersonsRepository;
import com.nazar.user_Managment.service.PersonService;
@RestController//обробляє http запити і поверта дані у json or xml
@RequestMapping("/persons")//path
public class PersonController {
		
	private final PersonsRepository personsRepository;
		
	private final PersonService personService;
	
	public PersonController(PersonsRepository personsRepository, PersonService personService) {
		this.personsRepository = personsRepository;
		this.personService = personService;
	}
		
	@PostMapping//позначає метод контролера, який повинен реагувати на POST-запити на вказаний шлях
	public void createPerson(@RequestBody Person person) {
		//save person to the db
		personsRepository.save(person);
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getPerson(@PathVariable Long id){
		return personService.getPerson(id);
	}
	
	@DeleteMapping("/{id}")
	public void removePerson(Long id) {
		personService.removePerson(id);
	}
	
	@PostMapping
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@PutMapping("/{id}")
	public Optional<Person> updatePerson(Long id, @RequestBody Person personDetails){
		return personService.updatePerson(id, personDetails);
	}
}
