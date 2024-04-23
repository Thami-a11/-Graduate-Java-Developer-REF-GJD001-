package com.enviro.assessment.grad001.ThamsanqaDyantyi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class DisposalGuidelines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 255)
    private String category;
	
	@NotNull
	@Size(max = 255)
    private String guidelines;
    
    //Constructors
    public DisposalGuidelines() {
    	
    }
    
    
    
	public DisposalGuidelines(String category, String guidelines) {
		this.category = category;
		this.guidelines = guidelines;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the guidelines
	 */
	public String getGuidelines() {
		return guidelines;
	}
	/**
	 * @param guidelines the guidelines to set
	 */
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}

}
