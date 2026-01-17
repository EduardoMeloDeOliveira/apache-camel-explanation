package io.githhub.EduardoMelo.apache_camel_explanation.controller;

import io.githhub.EduardoMelo.apache_camel_explanation.model.Person;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id) {
        Person found = producerTemplate.requestBodyAndHeader("direct:read-person", null, "id", id, Person.class);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Validated Person person) {
        person.setId(id);
        Person updated = producerTemplate.requestBody("direct:update-person", person, Person.class);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Person deleted = producerTemplate.requestBodyAndHeader("direct:delete-person", null, "id", id, Person.class);
        return deleted != null ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }
}
