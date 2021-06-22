package com.dws.costumerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	RegionService serviceregion;
	
	@GetMapping
	public ResponseEntity<Object> getRegions(){
		return new ResponseEntity<>(serviceregion.getRegions(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getRegion(@PathVariable("id") int id){
		return new ResponseEntity<>(serviceregion.getRegion(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createRegion(@RequestBody Region region){
		return new ResponseEntity<>(serviceregion.createRegion(region),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRegion(@PathVariable("id") int id, @RequestBody Region region){
		return new ResponseEntity<>(serviceregion.updateRegion(region,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removeRegion(@PathVariable("id") int id){
		return new ResponseEntity<>(serviceregion.deleteRegion(id),HttpStatus.OK);
	}	
}
