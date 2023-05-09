package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Autowired
	EntityManager em;
	
	public void insert( Employee employee ) {
		em.persist(employee);
	}
	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees(){
		
		return em.createQuery("Select e from PartTimeEmployee e" , PartTimeEmployee.class).getResultList();
		
	}
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees(){
		
		return em.createQuery("Select e from FullTimeEmployee e" , FullTimeEmployee.class).getResultList();
		
	}

}
