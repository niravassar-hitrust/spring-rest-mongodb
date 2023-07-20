package com.example.springrestmongodb.controller;

import com.example.springrestmongodb.data.Person;
import com.example.springrestmongodb.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/do-stuff")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public String doStuff() {
        List<Person> persons = personRepository.findAll();
        System.out.println("People in the db");
        persons.forEach(person -> System.out.println("id: " + person.getId() +  " " + person.getFirstName() + " " + person.getLastName()));

        Person rina = new Person();
        rina.setFirstName("Rina");
        rina.setLastName("Assar");

        personRepository.save(rina);

        List<Person> assarNames = personRepository.findByLastName("Assar");

        System.out.println("People named Assar");
        assarNames.forEach(person -> System.out.println("id: " + person.getId() +  " " + person.getFirstName() + " " + person.getLastName()));

        return "See sysout comments in the app";
    }
}
