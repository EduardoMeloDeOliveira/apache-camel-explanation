package io.githhub.EduardoMelo.apache_camel_explanation.processors;

import io.githhub.EduardoMelo.apache_camel_explanation.model.Person;
import io.githhub.EduardoMelo.apache_camel_explanation.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonDeleteProcessor implements Processor {

    private final PersonRepository personRepository;

    @Override
    public void process(Exchange exchange) throws Exception {
        Long id = exchange.getIn().getHeader("id", Long.class);

        if (id == null) {
            throw new IllegalArgumentException("ID is required");
        }

        Optional<Person> optinalPerson = personRepository.findById(id);


        if (optinalPerson.isPresent()) {
            personRepository.delete(optinalPerson.get());
            exchange.getMessage().setBody(true);
        } else {
            exchange.getMessage().setBody(false);
        }
    }

}
