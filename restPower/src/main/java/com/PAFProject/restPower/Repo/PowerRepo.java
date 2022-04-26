package com.PAFProject.restPower.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PAFProject.restPower.Models.PManagement;

public interface PowerRepo extends JpaRepository<PManagement , Long> {
	
	

}
