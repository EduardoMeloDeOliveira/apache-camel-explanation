package io.githhub.EduardoMelo.apache_camel_explanation.controller;

import io.githhub.EduardoMelo.apache_camel_explanation.model.Person;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final ProducerTemplate producerTemplate;


    @PostMapping
    public ResponseEntity<Person>createPerson (@Valid @RequestBody Person person){
        Person createdPerson  = producerTemplate.requestBody("direct:create-person",person,Person.class);
        return ResponseEntity.ok(createdPerson);
    }
}