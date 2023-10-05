package com.tlaxcala.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tlaxcala.model.Patient;

//import com.tlaxcala.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Integer> {
    
    //String sayHello(Patient patient);
}
