package com.enviro.assessment.grad001.ThamsanqaDyantyi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iDisposalGuidelinesRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.DisposalGuidelines;

@Service
public class DisposalGuidelinesService {

	private final iDisposalGuidelinesRepository disposalGuidelinesRepository;

	@Autowired
	public DisposalGuidelinesService(iDisposalGuidelinesRepository disposalGuidelinesRepository) {
		this.disposalGuidelinesRepository = disposalGuidelinesRepository;
	}

	// Method to retrieve all disposal guidelines
	public Iterable<DisposalGuidelines> getAllDisposalGuidelines() {
		return disposalGuidelinesRepository.findAll();
	}

	// Method to retrieve a single disposal guideline by its ID
	public Optional<DisposalGuidelines> getDisposalGuidelineById(Long id) {
		return disposalGuidelinesRepository.findById(id);
	}

	// Method to save a disposal guideline
	public DisposalGuidelines saveDisposalGuideline(DisposalGuidelines disposalGuidelines) {
		return disposalGuidelinesRepository.save(disposalGuidelines);
	}

	// Method to delete a disposal guideline by its ID
	public boolean deleteDisposalGuidelineById(Long id) {
		
		if (disposalGuidelinesRepository.existsById(id)) {
			
			disposalGuidelinesRepository.deleteById(id);
			return true;
		} else
			return false;
	}
}
