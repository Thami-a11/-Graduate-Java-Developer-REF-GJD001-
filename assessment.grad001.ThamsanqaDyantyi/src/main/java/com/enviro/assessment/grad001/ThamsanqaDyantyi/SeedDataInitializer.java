package com.enviro.assessment.grad001.ThamsanqaDyantyi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iDisposalGuidelinesRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iRecycleTipsRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository.iWasteRepository;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.DisposalGuidelines;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.RecycleTips;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.Waste;

@Component
public class SeedDataInitializer implements CommandLineRunner {

	private final iWasteRepository wasteRepository;

	private final iDisposalGuidelinesRepository disposalGuidelinesRepository;

	private final iRecycleTipsRepository RecycleTipsRepository;

	public SeedDataInitializer( iWasteRepository wasteRepository,
								iDisposalGuidelinesRepository disposalGuidelinesRepository,
								iRecycleTipsRepository RecycleTipsRepository) 
	{
		this.wasteRepository = wasteRepository;
		this.disposalGuidelinesRepository = disposalGuidelinesRepository;
		this.RecycleTipsRepository = RecycleTipsRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		// seed data when applications is starts to run
        wasteRepository.save(new Waste("Plastic Bottle", "Recyclable", "Dispose in the recycling bin."));
        wasteRepository.save(new Waste("Apple Core", "Organic", "Compost it."));
        
        disposalGuidelinesRepository.save(new DisposalGuidelines("Plastic Bottle", "Recycle in recycling bin."));
        disposalGuidelinesRepository.save(new DisposalGuidelines("Glass Bottle", "Recycle in recycling bin."));
        
        RecycleTipsRepository.save(new RecycleTips("Reduce, Reuse, Recycle"));
        RecycleTipsRepository.save(new RecycleTips("Use Reusable Bags"));
       
  
		
	}

}
