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

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Service.WasteService;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.Waste;

@RestController
@RequestMapping("/api/waste")
public class WasteController {

	private final WasteService wasteService;

	@Autowired
	public WasteController(WasteService wasteItemService) {
		this.wasteService = wasteItemService;
	}

	@GetMapping
	public Iterable<Waste> getAllWasteItems() {
		return wasteService.getAllWaste();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Waste> getWasteItemById(@PathVariable Long id) {

		Optional<Waste> wasteOptional = wasteService.getwasteByid(id);
		if (wasteOptional.isPresent()) {
			return ResponseEntity.ok(wasteOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> saveWasteItem(@RequestBody Waste waste) {
		try {
			Waste savedWaste = wasteService.saveWaste(waste);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedWaste);
		} 
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to save Waste item: " + e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteWasteItemById(@PathVariable Long id) {
		boolean deleted = wasteService.delete(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
