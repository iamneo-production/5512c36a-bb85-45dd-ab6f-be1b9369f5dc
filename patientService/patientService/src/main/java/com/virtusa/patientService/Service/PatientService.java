package com.virtusa.patientService.Service;

import com.virtusa.patientService.Entity.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(Long patientId);
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
}
