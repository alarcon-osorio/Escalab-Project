package com.tlaxcala.repo;

import com.tlaxcala.model.Patient;

public class PatientRepo {

    public String sayHello(Patient patient) {
        return "Hi " + patient.getFirstName();
    }

}
