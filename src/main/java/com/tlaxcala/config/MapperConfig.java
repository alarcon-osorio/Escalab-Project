package com.tlaxcala.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tlaxcala.dto.MedicDTO;
import com.tlaxcala.model.Medic;

@Configuration
public class MapperConfig {
    
    // le vamos a situar un bean personalizado en la memoria a Spring
    // clase intermediaria como bean para la interacción con el cliente
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper medicMapper() {
        ModelMapper mapper = new ModelMapper();

        // Escritura
        TypeMap<MedicDTO, Medic> typeMap1 = mapper.createTypeMap(MedicDTO.class, Medic.class);

        // Lectura
        TypeMap<Medic, MedicDTO> typeMap2 = mapper.createTypeMap(Medic.class, MedicDTO.class);

        return mapper;
    }
}
