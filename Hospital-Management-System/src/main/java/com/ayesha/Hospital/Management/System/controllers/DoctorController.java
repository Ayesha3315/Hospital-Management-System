package com.ayesha.Hospital.Management.System.controllers;

import com.ayesha.Hospital.Management.System.models.Doctor;
import com.ayesha.Hospital.Management.System.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        Doctor createdDoctor=doctorService.createDoctor(doctor);
        if(createdDoctor != null){
            return new ResponseEntity<>(createdDoctor,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> findAllDoctors(){
        List<Doctor> doctors= doctorService.findAllDoctors();
        if (doctors !=null){
            return new ResponseEntity<>(doctors,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable("id") long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable("id") long id){
        Doctor doctor=doctorService.findDoctorById(id);
        if(doctor!=null){
            doctorService.deleteDoctorById(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctorById(@PathVariable("id") long id,Doctor updatedDoctor){
        Doctor doctor=doctorService.findDoctorById(id);
        if(doctor!=null){
            doctorService.updatedDoctor(id,updatedDoctor);
            return new ResponseEntity<>(doctor,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
