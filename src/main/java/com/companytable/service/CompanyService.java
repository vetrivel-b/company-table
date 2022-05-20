package com.companytable.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.companytable.dao.Company;
import com.companytable.exceptioin.ResourceNotFoundException;
import com.companytable.repository.CompanyRepository;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repo;
	
	public List<Company> viewList() {
		return repo.findAll();
	}
	
	public Company newCompany(Company comp) {
		return repo.save(comp);
	}

	public Company UpdateById(long companyId, Company comp) {
		Company existingDetails=repo.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("company not found with this Id "+companyId));
		existingDetails.setCompanyName(comp.getCompanyName());
		existingDetails.setLocation(comp.getLocation());
		return repo.save(existingDetails);
	}

	public ResponseEntity<Company> deleteById(long companyId) {
		Company comp=repo.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("company not found with this Id"+companyId));
		repo.delete(comp);
		
		return ResponseEntity.ok().build();
	}

	

	
}
