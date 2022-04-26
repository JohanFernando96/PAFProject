package com.electroGrid.app.Rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
	
	@Autowired
	private BillRepo billRepo;
	
	
	@GetMapping(value ="/")
	public String getPage() {
		return "Welcome";
	}
	@GetMapping(value="/bill")
	public List<Bill> getBills() {
		return billRepo.findAll();
	}
	
	@PostMapping(value= "/save")
	public String saveBill(@RequestBody Bill bill) {
		billRepo.save(bill);
		return "Bill Details added";
	}
	@PutMapping(value = "/update/{billID}")
	public String updateBill(@PathVariable long billID,@RequestBody Bill bill) {
		Bill updatedBill = billRepo.findById(billID).get();
		updatedBill.setCusID(bill.getCusID());
		updatedBill.setNoOfWatts(bill.getNoOfWatts());
		updatedBill.setAmount(bill.getAmount());
		updatedBill.setTotal(bill.getTotal());
		billRepo.save(updatedBill);		
		return "Bill has updated";
		}
	@DeleteMapping(value="/delete/{billID}")
	public String DeleteBill(@PathVariable long billID) {
		Bill DeleteBill =billRepo.findById(billID).get();
		billRepo.delete(DeleteBill);
		return "Deleted bill with the ID:"+billID;
		
		
	}

}
