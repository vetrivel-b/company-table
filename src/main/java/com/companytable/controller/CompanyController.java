package com.companytable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companytable.dao.Company;
import com.companytable.service.CompanyService;


@RestController
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@GetMapping("/viewCompany")
	public List<Company> viewCompanyList() {
		return  service.viewList();
	}
	
	@PostMapping("/addCompany")
	public Company addNewCompany(@RequestBody Company comp) {
		return service.newCompany(comp);
	}
	
	@PutMapping("/update/{companyId}")
	public Company updateCompany(@PathVariable long companyId, @RequestBody Company comp) {
		return service.UpdateById(companyId, comp);
	}
	
	@DeleteMapping("/deleteCompany/{companyId}")
	public ResponseEntity<Company> deleteCompany(@PathVariable long companyId) {
		return service.deleteById(companyId);
	} 
}
