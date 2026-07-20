package com.ayesha.Hospital.Management.System.services;

import com.ayesha.Hospital.Management.System.models.Appointment;
import com.ayesha.Hospital.Management.System.repositories.AppointmentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);


    public Appointment createAppointment(Appointment appointment) {
        try {
            return appointmentRepo.save(appointment);
        } catch (Exception e) {
            logger.error("An error occurred while creating an appointment {}", e.getMessage(), e);
            return null;
        }
    }

    public List<Appointment> findAllAppointments() {
        try {
            return appointmentRepo.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting a list of appointments {}", e.getMessage(), e);
            return null;
        }
    }

    public Appointment getAppointmentById(long id) {
        try {
            Optional<Appointment> appointment = appointmentRepo.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching the appointment by id {}:{}", id, e.getMessage(), e);
            return null;
        }
    }

    public void deleteAppointment(long id) {
        try {
            appointmentRepo.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting the appointment of Id {}:{}", e.getMessage(), e);
        }
    }

    public Appointment updateAppoinment(long id, Appointment updatedAppointment) {
        try {
            Optional<Appointment> ExistingAppointment = appointmentRepo.findById(id);
            if (ExistingAppointment.isPresent()) {
                Appointment a = ExistingAppointment.get();
                a.setDate(updatedAppointment.getDate());
                a.setDoctorId(updatedAppointment.getDoctorId());
                a.setPatientId(updatedAppointment.getPatientId());
                appointmentRepo.save(a);
                return updatedAppointment;
            } else {
                logger.error("Appointment not found");
                return null;
            }

        } catch (Exception e) {
            logger.error("An error occurred while updating the appointment of id {}:{}", id, e.getMessage(), e);
            return null;
        }
    }

}

