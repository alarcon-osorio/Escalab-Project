package com.tlaxcala.service;

import java.util.List;

import com.tlaxcala.model.Patient;

public interface IPatientService extends ICRUD<Patient, Integer> {

   // DRY Principle: Don't repeat yourself! X
   // method: obtenga los pacientes ingresados a la UCI
   //List<Patient> getUCIPatients();

}
