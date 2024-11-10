package com.scaler.productservice.Configruations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigruations {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
