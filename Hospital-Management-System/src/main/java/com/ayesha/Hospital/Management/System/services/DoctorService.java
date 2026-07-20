package com.ayesha.Hospital.Management.System.services;

import com.ayesha.Hospital.Management.System.models.Doctor;
import com.ayesha.Hospital.Management.System.repositories.DoctorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    private static final Logger logger= LoggerFactory.getLogger(DoctorService.class);

    public Doctor createDoctor(Doctor doctor){
        try{
            return doctorRepo.save(doctor);
        } catch (Exception e) {
            logger.error("An error occured while creating the doctor {}",e.getMessage(),e);
            return null;
        }
    }

    public List<Doctor> findAllDoctors(){
        try{
            return doctorRepo.findAll();
        } catch (Exception e) {
            logger.error("An error occured while fetching the list of all the doctors {}",e.getMessage(),e);
            return null;
        }
    }

    public Doctor findDoctorById(long id){
        try{
            Optional<Doctor> doctor =doctorRepo.findById(id);
            return doctor.orElse(null);
        } catch (Exception e) {
            logger.error("An error occured while fetching the doctors by Id {}:{}",id,e.getMessage(),e);
            return null;
        }
    }

    public void deleteDoctorById(long id){
        try{
            doctorRepo.deleteById(id);
        }
        catch (Exception e) {
            logger.error("An error occured while deleting the doctor by Id {}:{}", id, e.getMessage(), e);
        }
    }

    public Doctor updatedDoctor(long id,Doctor updatedDoctor){
        try{
            Optional<Doctor> existingDoctor=doctorRepo.findById(id);
            if(existingDoctor.isPresent()){
               Doctor d= existingDoctor.get();
               d.setName(updatedDoctor.getName());
               d.setSpecialization(updatedDoctor.getSpecialization());
               doctorRepo.save(d);
               return updatedDoctor;
            }
            else {
                logger.error("Doctor not found");
                return null;
            }
        }
        catch (Exception e) {
            logger.error("An error occured while updating the doctor by Id {}:{}", id, e.getMessage(), e);
            return null;
        }

    }


}
