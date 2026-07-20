package com.ayesha.Hospital.Management.System.services;

import com.ayesha.Hospital.Management.System.models.Bill;
import com.ayesha.Hospital.Management.System.repositories.BillRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    private static final Logger logger= LoggerFactory.getLogger(BillService.class);

    public Bill createBill(Bill bill){
        try{
            return billRepo.save(bill);
        } catch (Exception e) {
            logger.error("An error is found while creating a bill {}",e.getMessage(),e);
            return null;
        }
    }

    public List<Bill> findAllBills(){
        try {
            return billRepo.findAll();
        } catch (Exception e) {
            logger.error("An error is found while finding all the bills {}",e.getMessage(),e);
            return null;
        }
    }

    public Bill findBillById(long id){
        try{
            Optional<Bill> bill=billRepo.findById(id);
            return bill.orElse(null);
        }
        catch (Exception e) {
            logger.error("An error is found while finding the bills by Id {}:{}",id,e.getMessage(),e);
            return null;
        }
    }

    public void deleteBillById(long id){
        try{
            billRepo.deleteById(id);
        }
        catch (Exception e) {
            logger.error("An error is found while deleting the bill of Id {}:{}",id,e.getMessage(),e);
        }
    }

    public Bill updateBill(long id,Bill updatedBill){
        try{
            Optional<Bill> existingBills=billRepo.findById(id);
            if(existingBills.isPresent()){
                Bill b=existingBills.get();
                b.setAmount(updatedBill.getAmount());
                b.setPatientId(updatedBill.getPatientId());
                b.setStatus(updatedBill.getStatus());
                billRepo.save(b);
                return updatedBill;
            }
            else {
                logger.error("Bill not found");
                return null;
            }
        }
        catch (Exception e) {
            logger.error("An error is found while updating the bill of id {}:{}",id,e.getMessage(),e);
            return null;
        }
    }
}
