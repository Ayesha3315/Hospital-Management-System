package com.ayesha.Hospital.Management.System.repositories;

import com.ayesha.Hospital.Management.System.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
