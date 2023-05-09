package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // SOLO UNA TABLA
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // TABLA POR CLASE
//@Inheritance(strategy=InheritanceType.JOINED) // MUCHAS CONSULTAS INTERNAS
//@DiscriminatorColumn( name = "EmployeeType" )
@MappedSuperclass
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column()
	private String name;
	
	public Employee() {}
	
	public Employee(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	

}
