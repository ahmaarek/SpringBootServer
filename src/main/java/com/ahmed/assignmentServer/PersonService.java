package com.ahmed.assignmentServer;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);
    List<Person> fetchPersonList();
    Person updatePerson(Person person, String username);

    void deletePersonByUsername(String username);
}
