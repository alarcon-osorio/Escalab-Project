package com.tlaxcala.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    
    // le vamos a situar un bean personalizado en la memoria a Spring
    // clase intermediaria como bean para la interacción con el cliente
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
