package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Course;


//@RepositoryRestResource( path ="courses" ) // Opc
public interface CourseSpringDataJPARepository extends JpaRepository<Course,Long>{
	
	List<Course> findByName(String name);
	Long countByName(String name);
	List<Course> findByNameAndId(String name , Long id);
	List<Course> findByNameOrderByIdDesc(String name);
	void deleteByName(String name);
	
	@Query("Select c From Course c where name like '%Math'")
	List<Course> courseWith();
	
	@Query(value="Select * From Course c where name like '%Math'", nativeQuery=true)
	List<Course> courseWithNative();

}
