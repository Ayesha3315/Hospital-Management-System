package com.ayesha.Hospital.Management.System.controllers;

import com.ayesha.Hospital.Management.System.models.Bill;
import com.ayesha.Hospital.Management.System.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<Bill> createBills(@RequestBody  Bill bill){
        Bill createdBills=billService.createBill(bill);
        if(createdBills!=null){
            return new ResponseEntity<>(bill, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("unused")
    @GetMapping
    public ResponseEntity<List<Bill>> findAllBills(){
        List<Bill> bills=billService.findAllBills();
        if (bills!=null){
            return new ResponseEntity<>(bills,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findBillById(@PathVariable("id") long id){
        Bill bill=billService.findBillById(id);
        if(bill!=null){
            return new ResponseEntity<>(bill,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillById(@PathVariable("id") long id){
        Bill bill=billService.findBillById(id);
        if(bill != null){
            billService.deleteBillById(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable("id") long id,@RequestBody Bill updatedBill){
        Bill bill=billService.updateBill(id,updatedBill);
        if(bill!=null){
            return new ResponseEntity<>(bill,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
