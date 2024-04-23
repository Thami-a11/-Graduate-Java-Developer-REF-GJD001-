package com.enviro.assessment.grad001.ThamsanqaDyantyi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Service.DisposalGuidelinesService;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.DisposalGuidelines;

//Annotations
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelinesController {
	
	 private final DisposalGuidelinesService disposalGuidelinesService;

	    @Autowired
	    public DisposalGuidelinesController(DisposalGuidelinesService disposalGuidelinesService) {
	        this.disposalGuidelinesService = disposalGuidelinesService;
	    }

	    @GetMapping
	    public Iterable<DisposalGuidelines> getAllDisposalGuidelines() {
	        return disposalGuidelinesService.getAllDisposalGuidelines();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DisposalGuidelines> getDisposalGuidelineById(@PathVariable Long id) {
	    	 Optional<DisposalGuidelines> DisposalGuidelines = disposalGuidelinesService.getDisposalGuidelineById(id);
	    	 if(DisposalGuidelines.isPresent()) {
	    		 return ResponseEntity.ok(DisposalGuidelines.get());
	    	 }
	    	 else
	    		 return ResponseEntity.notFound().build();
	    }

	    @PostMapping
	    public ResponseEntity<?> saveDisposalGuideline(@RequestBody DisposalGuidelines disposalGuidelines) {
	        try {
	        	DisposalGuidelines DisposalGuidelines = disposalGuidelinesService.saveDisposalGuideline(disposalGuidelines);
				return ResponseEntity.status(HttpStatus.CREATED).body(DisposalGuidelines);
			} 
			catch (Exception e)
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Failed to Guideline: " + e.getMessage());
			}
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteDisposalGuidelineById(@PathVariable Long id) {
	        boolean deleted = disposalGuidelinesService.deleteDisposalGuidelineById(id);
			if (deleted) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
			} else {
				return ResponseEntity.notFound().build();
			}
	    }
}
