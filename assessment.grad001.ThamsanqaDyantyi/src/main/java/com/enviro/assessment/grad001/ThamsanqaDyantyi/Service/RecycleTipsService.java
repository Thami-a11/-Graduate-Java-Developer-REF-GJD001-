package com.enviro.assessment.grad001.ThamsanqaDyantyi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iRecycleTipsRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.RecycleTips;

import java.util.Optional;

@Service
public class RecycleTipsService {

	private final iRecycleTipsRepository recycleTipsRepository;

	@Autowired
	public RecycleTipsService(iRecycleTipsRepository recycleTipsRepository) {
		this.recycleTipsRepository = recycleTipsRepository;
	}

	// Method to retrieve all recycling tips
	public Iterable<RecycleTips> getAllRecyclingTips() {
		return recycleTipsRepository.findAll();
	}

	// Method to retrieve a single recycling tip by its ID
	public Optional<RecycleTips> getRecyclingTipById(Long id) {
		return recycleTipsRepository.findById(id);
	}

	// Method to save a recycling tip
	public RecycleTips saveRecyclingTip(RecycleTips recyclingTips) {
		return recycleTipsRepository.save(recyclingTips);
	}

	// Method to delete a recycling tip by its ID
	public boolean deleteRecyclingTipById(Long id) {
		if (recycleTipsRepository.existsById(id)) {
			
			recycleTipsRepository.deleteById(id);
			return true;
			
		} else
			
			return false;
	}
}
