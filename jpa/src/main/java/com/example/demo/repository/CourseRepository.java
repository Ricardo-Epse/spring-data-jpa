package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById( Long id ) {
		 return em.find(Course.class, id);
	}
	
	public Course save( Course course ) {
		if(course.getId() == null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		
		return course;
	}
	
	public void deleteById( Long id ) {
		
		Course course = findById(id);
		em.remove(course);
	}
	
	public void EntityManagerTests() {
		logger.info("Play with entity manager");
		
		Course course1 = new Course("Nuevas cosas");
		em.persist(course1);
		
		Course course2 = findById(10002L);
		course2.setName("Cambio");
		

	}

	public void addReviewsForCourse() {
		// Get course 10003
		Course course = findById(10002L);
		logger.info("add reviews{}",course.getReviews());
		
		//add 2 reviews
		Review review = new Review("1","Bad course");
		Review review2 = new Review("2","bahhh");
		
		//Setting the relationship
		course.addReview(review);
		review.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review);
		em.persist(review2);
			
	}
	
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = findById(10001L);
		logger.info("{}", course.getReviews());	
	}
	
	
	public void addReviewsForCourse(Long courseId , List<Review> reviews) {
		// Get course
		Course course = findById(courseId);
		
		logger.info("add reviews: {}", course.getReviews());
		
		for( Review review : reviews) {
				
			course.addReview(review);
			review.setCourse(course);
			
			em.persist(review);
		}
	}



}

