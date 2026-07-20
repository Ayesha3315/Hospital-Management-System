package com.ayesha.Hospital.Management.System.controllers;

import com.ayesha.Hospital.Management.System.models.Appointment;
import com.ayesha.Hospital.Management.System.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<Appointment> createAppoinment(@RequestBody Appointment appointment){
        Appointment appointments=appointmentService.createAppointment(appointment);
        if(appointments!=null){
            return new ResponseEntity<>(appointments, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @SuppressWarnings("unused")
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppoinments(){
        List<Appointment> appointments=appointmentService.findAllAppointments();
        if(appointments!=null){
            return new ResponseEntity<>(appointments,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long id){
        Appointment appointment=appointmentService.getAppointmentById(id);
        if(appointment!=null){
            return new ResponseEntity<>(appointment,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppoinments(@PathVariable("id") long id){
        Appointment appointment=appointmentService.getAppointmentById(id);
        if(appointment!=null){
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id,@RequestBody Appointment updatedAppointment){
        Appointment appointment=appointmentService.updateAppoinment(id,updatedAppointment);
        if(appointment!=null){
            return new ResponseEntity<>(appointment,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
