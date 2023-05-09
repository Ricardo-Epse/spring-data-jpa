package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passport")
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="number", nullable= false , unique = true , updatable=true)
	private String number;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@OneToOne(fetch = FetchType.LAZY , mappedBy="passport")
	private  Student student;
	
	protected Passport() {	
	}
	
	public Passport(String number) {
		
		this.number = number;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}



}
