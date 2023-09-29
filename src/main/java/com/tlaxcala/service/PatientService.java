package com.tlaxcala.service;

import com.tlaxcala.model.Patient;
import com.tlaxcala.repo.PatientRepo;

public class PatientService {

    private PatientRepo repo = new PatientRepo();

    public String sayHelloLogic(Patient patient) {
        if (patient != null) {
            return repo.sayHello(patient);
        } else {
            return "There is no patient";
        }
    }
}
