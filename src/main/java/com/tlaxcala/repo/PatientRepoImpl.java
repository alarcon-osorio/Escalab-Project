package com.tlaxcala.repo;

import org.springframework.stereotype.Repository;

import com.tlaxcala.model.Patient;

@Repository
public class PatientRepoImpl implements IPatientRepo {

    @Override
    public String sayHello(Patient patient) {
        return "Hi " + patient.getFirstName(); 
    }
}
