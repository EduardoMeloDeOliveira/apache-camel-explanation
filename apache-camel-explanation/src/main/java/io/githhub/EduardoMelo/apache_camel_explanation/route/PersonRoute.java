package io.githhub.EduardoMelo.apache_camel_explanation.route;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("direct:create-person")
                .routeId("createPersonRoute")
                .log("Creating new person: ${body}")
//                .process() -> TODO: create PersonCretateProcessor
                .log("Person created successfully with ID: ${body.id}");
    }
}
