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

import com.enviro.assessment.grad001.ThamsanqaDyantyi.Service.RecycleTipsService;
import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.RecycleTips;

@RestController
@RequestMapping("/api/recycle-tips")
public class RecyleTipsController {


    private final RecycleTipsService recyclingTipService;

    @Autowired
    public RecyleTipsController(RecycleTipsService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    @GetMapping
    public Iterable<RecycleTips> getAllRecyclingTips() {
        return recyclingTipService.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecycleTips> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecycleTips> recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return recyclingTip.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveRecyclingTip(@RequestBody RecycleTips recyclingTip) {
        try {
            RecycleTips savedRecyclingTip = recyclingTipService.saveRecyclingTip(recyclingTip);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecyclingTip);
            
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to save recycling tip: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecyclingTipById(@PathVariable Long id) 
    {
        boolean deleted = recyclingTipService.deleteRecyclingTipById(id);
        
        return deleted ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted")
        		
                       : ResponseEntity.notFound().build();
    }
}