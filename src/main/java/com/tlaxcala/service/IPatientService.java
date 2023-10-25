package com.tlaxcala.service;

import java.util.List;

import com.tlaxcala.model.Patient;

public interface IPatientService {

    Patient save(Patient patient);
    Patient update(Patient patient, Integer id);
    List<Patient> findAll();
    Patient findById(Integer id);
    void delete(Integer id);
}
