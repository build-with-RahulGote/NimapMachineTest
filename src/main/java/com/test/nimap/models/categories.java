package com.test.nimap.models;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data  //setter ,getters
@Entity //To mark class as Database entity

public class Categories {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id
	private int cid;

	private String cname;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL) //relation defining
	@JsonIgnoreProperties("category") //to prevent looping and recursion
	private List<Products> product;

}
