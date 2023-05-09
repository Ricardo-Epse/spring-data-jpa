package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class Jpql {
	

	
	/// 
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void PruebaJpqlPrimero() {
		List resultList = em.createQuery("Select c From Course c",Course.class).getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void PruebaJpqlSegundo() {
		Query query = em.createQuery("Select c From Course c");
		List resultList = query.getResultList();
		logger.info("Select c From Course c {}", resultList);
	}
	
	public void PruebaJpqlTercero() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void PruebaJpqlWhere() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%PRUEBA'",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void PruebaJpql() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}
	
	public void PruebaJpql2() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	public void PruebaJpql3() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_pruebas",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Primero {}", resultList);
	}
	
	
	///////////////////////////// 
	
	public void jpql_courses_without_students() {
		List resultList = em.createQuery("Select c From Course c where c.students is empty",Course.class).getResultList();
		logger.info("Results {}", resultList);
	}
	
	public void jpql_courses_with_atleast_two_students() {
		List resultList = em.createQuery("Select c From Course c where size(c.students) >= 2",Course.class).getResultList();
		logger.info("Results {}", resultList);
	}
	
	public void jpql_courses_with_ordered_by_students() {
		List resultList = em.createQuery("Select c From Course c order by size(c.students)",Course.class).getResultList();
		logger.info("Results {}", resultList);
	}
	
	public void jpql_courses_with_passports_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s From Student s where s.passport.number like '%124%'",Student.class);
		List resultList = query.getResultList();
		logger.info("Results {}", resultList);
	}
	
	public void join() {
		Query query = em.createQuery("Select c , s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results {}", resultList.size());
		
		for(Object[] result: resultList) {
			
			logger.info("Results {} {}",result[0],result[1]);

		}
	}
	
	public void left_join() {
		Query query = em.createQuery("Select c , s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results {}", resultList.size());
		
		for(Object[] result: resultList) {
			
			logger.info("Results {} {}",result[0],result[1]);

		}
	}
	
	public void cross_join() {
		Query query = em.createQuery("Select c , s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results {}", resultList.size());
		
		for(Object[] result: resultList) {
			
			logger.info("Results {} {}",result[0],result[1]);

		}
	}
	

}
