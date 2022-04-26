package com.PAFProject.restMonthlyBill.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PAFProject.restMonthlyBill.Models.Bills;
import com.PAFProject.restMonthlyBill.Repo.BillRepo;

@RestController
public class ApiControllers {
	
	@Autowired
	private BillRepo billRepo;
	
	@GetMapping(value="/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="/bills")
	public List<Bills> getBills(){
		return billRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveBill(@RequestBody Bills bills) {
		billRepo.save(bills);
		return "Saved...";
	}
	
	@PutMapping(value="update/{id}")
	public String updateBill(@PathVariable long id, @RequestBody Bills bills) {
		Bills updateBill = billRepo.findById(id).get();
		updateBill.setCustomerID(bills.getCustomerID());
		updateBill.setFirstName(bills.getFirstName());
		updateBill.setLastName(bills.getLastName());
		updateBill.setUnits(bills.getUnits());
		updateBill.setpUnit(bills.getpUnit());
		updateBill.setTotalPrice(bills.getTotalPrice());
		billRepo.save(updateBill);
		return "Updated...";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteBill(@PathVariable long id) {
		Bills deleteBill = billRepo.findById(id).get();
		billRepo.delete(deleteBill);
		return "Deleted Bill with the ID : "+id;
	}
	
	
}
