package com.tlaxcala.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tlaxcala.model.Patient;
//import com.tlaxcala.repo.IPatientRepo;
import com.tlaxcala.service.IPatientService;
//import com.tlaxcala.service.PatientServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patients") // -> buena práctica: la ruta padre siempre sea en plural
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        Patient obj = service.save(patient);
        // localhost:8081/patients/1
        // return new ResponseEntity<>(obj, HttpStatus.CREATED);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();
        // return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") Integer id) {
        Patient obj = service.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //@PutMapping("/{id}")
    @PutMapping("/{id}")
    //@PatchMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        Patient obj = service.update(patient, id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // forma 1: private PatientService service = new PatientService();
    // forma 2: private PatientServiceImpl service = new PatientServiceImpl();
    // forma 3: singleton
    //@Autowired
    //private PatientServiceImpl service;
    // forma 4: forma 4: utilizar como inyección la definición de la fachada directamente mediante constructor
    /*private final IPatientService service;

      public PatientController(IPatientService service) {
        this.service = service;
    }*/
    // forma 5: utilizar como inyección una interfaz de manera directa
    /*@Autowired
    private IPatientService service;*/
    // forma 6: utilizar como inyección una interfaz + una anotación

    /*@GetMapping()
    public String sayHelloREST() {
        Patient patient = new Patient(1, "Rusell");
        return service.sayHelloLogic(patient);
    }

    @GetMapping("/hello2")
    public String sayHelloREST2() {
        Patient patient = new Patient(2, "Luis");
        return service.sayHelloLogic(patient);
    }*/
}
