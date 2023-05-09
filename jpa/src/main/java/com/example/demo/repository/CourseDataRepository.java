package com.example.demo.repository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

@Repository
@Transactional
public class CourseDataRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataJPARepository repository;
	
	public void findById_present() {
		Optional<Course> courseOptional = repository.findById(10001L);
		logger.info("{}", courseOptional.isPresent());	
	}
	
	public void findById_notPresent() {
		Optional<Course> courseOptional = repository.findById(10011L);
		logger.info("{}", courseOptional.isPresent());	
	}
	
	public void test1() {
		Course course = new Course("Microservicios");
		repository.save(course);
		logger.info("-> {}",course.getName());
		
		course.setName("Microservicios, actualizado");
		repository.save(course);
		logger.info("-> {}",course.getName());
		
	}
	
	public void test2() {
		
		logger.info("-> {}",repository.findAll());
		logger.info("-> {}",repository.count());
	}
	
	public void sort() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		
		logger.info("-> {}",repository.findAll(sort));
		logger.info("-> {}",repository.count());
	}
	
	public void pagination() {
		
		PageRequest pageRequest = PageRequest.of(0,5);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("-> {}",firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		
		
		logger.info("-> {}",secondPage.getContent());
		//logger.info("-> {}",repository.count());
	}
	
	public void findUsingName() {
		
		logger.info("{}",repository.findByName("Math"));
	}
	
	public void countUsingName() {
		
		logger.info("{}",repository.countByName("Math"));
	}
	
	public void findUsingNameAndId() {
		
		logger.info("{}",repository.findByNameAndId("Math",10001L));
	}
	
	public void findUsingNameDesc() {
		
		logger.info("{}",repository.findByNameOrderByIdDesc("Math"));
	}
	
	public void courseWith() {
		
		logger.info("{}",repository.courseWith());
	}
	
	public void courseWithNative() {
		
		logger.info("{}",repository.courseWithNative());
	}
	
}


