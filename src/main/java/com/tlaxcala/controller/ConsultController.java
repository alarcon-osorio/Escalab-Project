package com.tlaxcala.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tlaxcala.dto.ConsultDTO;
import com.tlaxcala.dto.ConsultListExamDTO;
import com.tlaxcala.model.Consult;
import com.tlaxcala.model.Exam;
import com.tlaxcala.service.IConsultService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/consults")
@RequiredArgsConstructor
public class ConsultController {

    private final IConsultService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private ConsultDTO convertToDto(Consult obj) {
        return mapper.map(obj, ConsultDTO.class);
    }

    private Consult convertToEntity(ConsultDTO dto) {
        return mapper.map(dto, Consult.class);
    }

    @GetMapping
    public ResponseEntity<List<ConsultDTO>> findAll() {
        // podemos ocupar el api de programación funcional para el manejo de listas
        // mediante
        // la propiedad stream
        // cuando se hace referencia de un método dentro de un lambda yo puedo aplicar
        // una abreviación
        // List<ConsultDTO> listExample = service.findAll().stream().map(e ->
        // convertToDto(e)).toList();
        List<ConsultDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        // List<ConsultDTO> list = service.findAll().stream().map(e ->
        /*
         * List<ConsultRecord> list = service.findAll()
         * .stream().
         * map(e ->
         * new ConsultRecord(e.getIdConsult(), e.getFirstName(), e.getLastName(),
         * e.getDni(),
         * e.getAddress(), e.getPhone(), e.getEmail())
         * ).toList();
         */
        /*
         * {
         * 
         * ConsultDTO dto = new ConsultDTO();
         * dto.setIdConsult(e.getIdConsult());
         * dto.setFirstName(e.getFirstName());
         * dto.setLastName(e.getLastName());
         * dto.setDni(e.getDni());
         * dto.setPhone(e.getPhone());
         * dto.setEmail(e.getEmail());
         * dto.setAddress(e.getAddress());
         * return dto;
         * }
         * ).toList();
         */
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConsultDTO> save(@Valid @RequestBody ConsultListExamDTO dto) {
        Consult cons = this.convertToEntity(dto.getConsult());
        
        // alternativa 1
        //List<Exam> exams = dto.getLstExam().stream().map(e -> mapper.map(e, Exam.class)).toList();
        // alternativa 2
        List<Exam> exams = mapper.map(dto.getLstExam(), new TypeToken<List<Exam>>(){}.getType());

        Consult obj = service.saveTransactional(cons, exams);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsult())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultDTO> findById(@PathVariable("id") Integer id) {
        Consult obj = service.findById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consult> update(@PathVariable("id") Integer id, @RequestBody ConsultDTO dto) throws Exception {
        Consult obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consult> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // hateoas -> para tipo get
    @GetMapping("/hateoas/{id}")
    public EntityModel<ConsultDTO> findByHateoas(@PathVariable("id") Integer id) {
        EntityModel<ConsultDTO> resource = EntityModel.of(convertToDto(service.findById(id))); // la salida

        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id)); // la generación del link

        resource.add(link1.withRel("consult-info1")); // agregamos el link con una llave
        resource.add(link1.withRel("consult-info2"));

        return resource;
    }

}