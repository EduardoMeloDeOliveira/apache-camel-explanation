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
public class PersonReadProcessor implements Processor {

    private final PersonRepository personRepository;

    @Override
    public void process(Exchange exchange) throws Exception {
        Long id = exchange.getIn().getHeader("id", Long.class);

        if(id == null) {
            throw new IllegalArgumentException("ID is required");
        }

        Optional<Person> optionalPerson = personRepository.findById(id);


        if(optionalPerson.isEmpty()){
            exchange.getMessage().setBody(null);
        }else{
            exchange.getMessage().setBody(optionalPerson.get());
        }
    }

}
