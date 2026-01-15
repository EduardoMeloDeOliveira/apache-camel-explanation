package io.githhub.EduardoMelo.apache_camel_explanation.config;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean
    public ProducerTemplate producerTemplate(CamelContext context ){
        return context.createProducerTemplate();
    }
}
