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


@Repository
@Transactional
public class NativeQueries {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE",Course.class);
		List result = query.getResultList();
		logger.info("Query {}", result);
	}
	
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("Select * From Course WHERE id = ?",Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info(" {}", resultList);
	}
	
	
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("Select * From Course WHERE id = :id",Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info(" {}", resultList);
	}

	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("UPDATE Course set last_updated_date = CURRENT_DATE()",Course.class);
		int numOfRowsUdpated = query.executeUpdate();
		logger.info("updated querys{}", numOfRowsUdpated );
	}
}
