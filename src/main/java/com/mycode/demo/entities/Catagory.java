package com.mycode.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="catagories")
@NoArgsConstructor
@Getter
@Setter
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catagoryId;
	
	@Column(name="title",length = 100,nullable = false)
	private String catagoryTitle;
	
	@Column(name="description")
	private String catagoryDescription;
	
}