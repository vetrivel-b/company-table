package com.companytable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companytable.dao.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
