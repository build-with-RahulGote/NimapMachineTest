package com.test.nimap.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int String;
	
	@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
	private List<products>product;
	

}
