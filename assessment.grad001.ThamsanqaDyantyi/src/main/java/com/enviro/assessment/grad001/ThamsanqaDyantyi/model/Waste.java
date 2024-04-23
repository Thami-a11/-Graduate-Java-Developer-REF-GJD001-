package com.enviro.assessment.grad001.ThamsanqaDyantyi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity 
public class Waste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=50)
	private String name;
	
	@NotNull
	@Size(max= 255)
	private String category;
	
	@Size(max =255)
	private String description;
	
	public Waste() {
		
	}

	public Waste(String name, String category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
