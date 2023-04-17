package com.devsuperior.movieflix.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.movieflix.dtos.ReviewSaveDTO;
import com.devsuperior.movieflix.dtos.ReviewInsertDTO;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {
	
	 @Autowired
	 private ReviewService service;
	 
	 @PutMapping(value = "/{id}")
	 public ResponseEntity<Void> saveReview(@PathVariable Long id, @RequestBody ReviewSaveDTO dto){
		service.saveReview(id, dto);
		return ResponseEntity.noContent().build();
	 }
	 
	 @PostMapping
	 public ResponseEntity<ReviewInsertDTO> insertReview(@RequestBody ReviewInsertDTO dto){
		dto = service.insertReview(dto);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(dto.getId()).toUri();
	return ResponseEntity.created(uri).body(dto);
	 }

}
