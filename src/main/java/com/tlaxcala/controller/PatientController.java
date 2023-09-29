package com.tlaxcala.controller;

import com.tlaxcala.model.Patient;
import com.tlaxcala.service.PatientService;

public class PatientController {

    private PatientService service = new PatientService();

    public String sayHelloREST() {
        Patient patient = new Patient(1, "Rusell");
        return service.sayHelloLogic(patient);
    } 
}
