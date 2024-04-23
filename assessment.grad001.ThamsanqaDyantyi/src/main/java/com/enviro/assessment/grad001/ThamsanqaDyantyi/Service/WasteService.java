package com.enviro.assessment.grad001.ThamsanqaDyantyi.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iWasteRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.Waste;

@Service
public class WasteService {
	
	private final iWasteRepository iWasteRepository;
	
	public WasteService(iWasteRepository iWasteRepository) {
		this.iWasteRepository = iWasteRepository;
	}
	
	public Optional<Waste> getwasteByid(long id) {
		return this.iWasteRepository.findById(id);
	}
	
	public Waste saveWaste(Waste Waste) {
		return this.iWasteRepository.save(Waste);
	}
	
	public List<Waste> getAllWaste()
	{
		return this.iWasteRepository.findAll();
	}
	
	public boolean delete(long id) {
		if(this.iWasteRepository.existsById(id)) {
			this.iWasteRepository.deleteById(id);
			return true;
		}
		else
			return false;
	}

}
