package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

@Repository
@Transactional
public class CriteriaQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void criteria_basic() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		TypedQuery query  = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void criteria_course() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate likeP = cb.like(courseRoot.get("name"), "%Math");
		cq.where(likeP);
		
		TypedQuery query  = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void criteria_courses_withoutStudents() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate studentsEmpty = cb.isEmpty(courseRoot.get("students"));
		cq.where(studentsEmpty);
		
		TypedQuery query  = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void join() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Join<Object,Object> join = courseRoot.join("students");
		
		
		TypedQuery query  = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("-> {}", resultList);
	}

	
	public void join_left() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Join<Object,Object> join = courseRoot.join("students", JoinType.LEFT);
		
		
		TypedQuery query  = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("-> {}", resultList);
	}
}
