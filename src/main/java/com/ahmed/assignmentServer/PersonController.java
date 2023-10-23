package com.ahmed.assignmentServer;

import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.List;

    /*TODO

    -Figure out how to create (and populate) table

    -Test this

    -Post mapping for creating new entries

    -convert to response entities for http status code passing and exception handling

    */
@RestController
public class PersonController {

    @Resource(name = "personService")
    private JpaPersonService personService;


    @GetMapping("/allUsers")
    public List<Person> getAllPersons(){
        return personService.fetchPersonList();

    }

    @PostMapping("/newUser")
    public Person addPerson(@RequestParam(value="username")String username, @RequestParam(value="firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value="gender") boolean gender){
        return personService.savePerson(new Person(username, firstName,lastName, gender));
    }

    @GetMapping("/personFromClient")
    public Person getPersonFromClient(@RequestParam(name = "username") String username, @RequestParam(name="password")String password){
//        RestTemplate restTemplate = new RestTemplate();
//        String uri = "http://localhost:8082/userFromBody";
//        HttpHeaders header= new HttpHeaders();
//        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        header.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//        HttpEntity<String> entity = new HttpEntity<>("parameters", header);
//        ResponseEntity<User> result =
//                restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
//return result;

//        User user = restTemplate.getForObject(uri, User.class);
        Person person = personService.getPersonByUsername(username);
        return person;
    }

}
