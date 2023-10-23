package com.ahmed.assignmentServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class JpaPersonService  implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> fetchPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person person, String username) {
        Person toBeUpdated =  personRepository.findById(username).get();
        toBeUpdated.setFirstName(person.getFirstName());
        toBeUpdated.setLastName(person.getLastName());
        toBeUpdated.setGender(person.isGender());
        return personRepository.save(toBeUpdated);
    }

    @Override
    public void deletePersonByUsername(String username) {
        personRepository.deleteById(username);
    }

    public Person getPersonByUsername(String username){
        return personRepository.getReferenceById(username);
    }
}
