package com.test.nimap.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	private int cid;
	
	
	private  String cname;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	  @JsonIgnore
	private List<products>product;
	

}
