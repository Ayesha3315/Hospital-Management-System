package com.ayesha.Hospital.Management.System.repositories;

import com.ayesha.Hospital.Management.System.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {

}
