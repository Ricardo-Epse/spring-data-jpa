package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	StudentRepository repository;
	
	public Student findById( Long id ) {
		 return em.find(Student.class, id);
	}
	
	public Student save( Student Student ) {
		if(Student.getId() == null) {
			em.persist(Student);
		}else {
			em.merge(Student);
		}
		
		return Student;
	}
	
	public void deleteById( Long id ) {
		
		Student Student = findById(id);
		em.remove(Student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("SB31992J");
		em.persist(passport);
		
		logger.info("Play with entity manager");
		Student student = new Student("Yahir");
		
		student.setPassport(passport);
		
		em.persist(student);
	}
	
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class , 20001L);
		logger.info("Student {} " , student );
		logger.info("passport {}" , student.getPassport());	
	}
	
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class , 30001L);
		logger.info("passport {} " , passport );
		logger.info("passport {}" , passport.getStudent());	
	}
	
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}
	
	public void insertStudentAndCourseOne() {
		
		Student student = new Student("Diego");
		Course course = new Course("Biology");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
		
	}
	
	
	public void insertStudentAndCourse(Student student , Course course ) {
		
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
		em.persist(course);
		
	}
	

}
