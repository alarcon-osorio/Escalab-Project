package com.tlaxcala.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tlaxcala.model.Patient;
import com.tlaxcala.repo.IPatientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepo repo;

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient, Integer id) {
        patient.setIdPatient(id);
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) {
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
