package com.ayesha.Hospital.Management.System.repositories;

import com.ayesha.Hospital.Management.System.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

}
