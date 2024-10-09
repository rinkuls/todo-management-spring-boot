package com.todo.springboot.todomanagementspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student  {

	private static final long serialVersionUID = 1378945L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private  Long empId;
	private  String firstName;
	private  String lastName;
	private  Integer age;




}
