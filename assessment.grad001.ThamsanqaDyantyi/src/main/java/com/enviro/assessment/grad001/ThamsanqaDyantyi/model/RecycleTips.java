package com.enviro.assessment.grad001.ThamsanqaDyantyi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RecycleTips {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 255)
	private String tip;

	

	public RecycleTips() {
	}

	/**
	 * @param id
	 * @param tip
	 */
	public RecycleTips(String tip) {
		this.tip = tip;
	}

	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
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
}
