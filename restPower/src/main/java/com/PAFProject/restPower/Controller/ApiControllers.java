package com.PAFProject.restPower.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PAFProject.restPower.Models.PManagement;
import com.PAFProject.restPower.Repo.PowerRepo;

@RestController
public class ApiControllers {
	
	@Autowired
	private PowerRepo powerRepo;
	
	@GetMapping(value="/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="/power")
	public List<PManagement> getReport(){
		return powerRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveReport(@RequestBody PManagement power) {
		powerRepo.save(power);
		return "Saved...";
	}
	
	@PutMapping(value="update/{id}")
	public String updateReport(@PathVariable long id, @RequestBody PManagement power) {
		PManagement updateReport = powerRepo.findById(id).get();
		updateReport.setCustomerID(power.getCustomerID());
		updateReport.setFirstName(power.getFirstName());
		updateReport.setLastName(power.getLastName());
		updateReport.setUnits(power.getUnits());
		updateReport.setpUnit(power.getpUnit());
		powerRepo.save(updateReport);
		return "Updated...";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteReport(@PathVariable long id) {
		PManagement deleteReport = powerRepo.findById(id).get();
		powerRepo.delete(deleteReport);
		return "Deleted Bill with the ID : "+id;
	}
	
	
}
