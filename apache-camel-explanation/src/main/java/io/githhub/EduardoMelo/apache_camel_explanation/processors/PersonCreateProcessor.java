package io.githhub.EduardoMelo.apache_camel_explanation.processors;

import io.githhub.EduardoMelo.apache_camel_explanation.model.Person;
import io.githhub.EduardoMelo.apache_camel_explanation.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonCreateProcessor implements Processor {

    private final PersonRepository personRepository;

    @Override
    public void process(Exchange exchange) throws Exception {

        Person person = exchange.getIn().getBody(Person.class);

        if(person == null) {
            throw new IllegalArgumentException("Person object is required");
        }

        Person savedPerson = personRepository.save(person);

        exchange.getMessage().setBody(savedPerson);

    }
}
