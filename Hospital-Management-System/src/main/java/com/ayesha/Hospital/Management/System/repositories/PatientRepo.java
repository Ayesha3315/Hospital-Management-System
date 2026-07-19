package com.ayesha.Hospital.Management.System.repositories;

import com.ayesha.Hospital.Management.System.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
