package com.PAFProject.restPower.Models;

import javax.persistence.*;

@Entity
public class PManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int customerID;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int units;
	
	@Column
	private int pUnit;
	
	
	
	public long getId() {
		return id;
	}
	public int getCustomerID() {
		return customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getUnits() {
		return units;
	}
	public int getpUnit() {
		return pUnit;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public void setpUnit(int pUnit) {
		this.pUnit = pUnit;
	}

}
