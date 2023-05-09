package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Course")
@NamedQueries( value = {
		@NamedQuery(name = "query_get_all_courses", query="Select c from Course c"),
		@NamedQuery(name = "query_get_all_prueba1", query=" Select c from Course c WHERE name like 'PRUEBA 1' "),
})

public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable= false , unique = true , updatable=true)
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
//	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Course() {
		
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	public Course( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setReview(List<Review> review) {
		this.reviews = review;
	}

//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", name=" + name + ", review=" + reviews + ", lastUpdatedDate=" + lastUpdatedDate
//				+ ", createdDate=" + createdDate + "]";
//	}
	
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}


}
