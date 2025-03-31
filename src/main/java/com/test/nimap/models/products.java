package com.test.nimap.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data // setter ,getters
@Entity // to mark class as Database entity
@Table(name = "products")
public class Products {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private int pid;
	private String pname;
	private double price;

	@ManyToOne(fetch = FetchType.EAGER) // relationship
	@JoinColumn(name = "category_id", referencedColumnName = "cid") // column with foreign key
	@JsonIgnoreProperties("products") // prevent looping
	private categories category;

}
