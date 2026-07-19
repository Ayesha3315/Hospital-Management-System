package com.ayesha.Hospital.Management.System.services;

import com.ayesha.Hospital.Management.System.models.Patient;
import com.ayesha.Hospital.Management.System.repositories.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getAllPatients() {
        try {
            return patientRepo.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while fetching all patients:{}", e.getMessage(), e);
            return null;
        }
    }

    public Patient getPatientById(long id) {
        try {
            Optional<Patient> patient = patientRepo.findById(id);
            return patient.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching patients by Id {}:{}", id, e.getMessage(), e);
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            return patientRepo.save(patient);
        } catch (Exception e) {
            logger.error("An error occured while creating the patient {}", e.getMessage(), e);
            return null;
        }
    }

    public void deletePatientById(long id) {
        try {
            patientRepo.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occured while creating the patient {}", e.getMessage(), e);
        }
    }
    public Patient updatePatient(long id,Patient updatedPatient){
        try {
            Optional<Patient> existingPatient = patientRepo.findById(id);
            if (existingPatient.isPresent()) {
                Patient p=existingPatient.get();
                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                patientRepo.save(p);
                return updatedPatient;
            }
            else {
                logger.error("Patient not found of id{}",id);
                return null;
            }
        }
        catch (Exception e) {
            logger.error("An error occured while updating the patient {}", e.getMessage(), e);
            return null;
        }
    }
}
