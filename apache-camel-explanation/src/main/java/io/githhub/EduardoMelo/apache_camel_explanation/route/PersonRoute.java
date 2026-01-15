package io.githhub.EduardoMelo.apache_camel_explanation.route;

import io.githhub.EduardoMelo.apache_camel_explanation.processors.PersonCreateProcessor;
import io.githhub.EduardoMelo.apache_camel_explanation.processors.PersonDeleteProcessor;
import io.githhub.EduardoMelo.apache_camel_explanation.processors.PersonReadProcessor;
import io.githhub.EduardoMelo.apache_camel_explanation.processors.PersonUpdateProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRoute extends RouteBuilder {

    private final PersonCreateProcessor personCreateProcessor;
    private final PersonReadProcessor personReadProcessor;
    private final PersonUpdateProcessor personUpdateProcessor;
    private final PersonDeleteProcessor personDeleteProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:create-person")
                .routeId("createPersonRoute")
                .log("Creating new person: ${body}")
                .process(personCreateProcessor)
                .log("Person created successfully with ID: ${body.id}");


        from("direct:read-person")
                .routeId("readPersonRoute")
                .log("Reading person with id ${header.id}")
                .process(personReadProcessor)
                .choice()
                .when(body().isNull())
                .setHeader("CammelHttpResponseCode", constant(404))
                .setBody(constant("Person not found"))
                .otherwise()
                .log("Person found: ${body}");


        from("direct:update-person")
                .routeId("updatePersonRoute")
                .log("Updating person: ${body}")
                .process(personUpdateProcessor)
                .choice()
                .when(body().isNull())
                .setHeader("CammelHttpResponseCode", constant(404))
                .setBody(constant("Person not found"))
                .otherwise()
                .log("Person updated successfully: ${body}");


        from("direct:delete-person")
                .routeId("deletePersonRoute")
                .log("Deleting person with id ${header.id}")
                .process(personDeleteProcessor)
                .choice()
                .when(body().isEqualTo(false))
                .setHeader("CammelHttpResponseCode", constant(404))
                .setBody(constant("Person not found"))
                .otherwise()
                .log("Person deleted successfully with id ${header.id}");


    }
}
