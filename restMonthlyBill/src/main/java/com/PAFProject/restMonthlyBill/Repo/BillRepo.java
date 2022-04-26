package com.PAFProject.restMonthlyBill.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PAFProject.restMonthlyBill.Models.Bills;

public interface BillRepo extends JpaRepository<Bills , Long> {
	
	

}
