package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.MovieDetailsDTO;
import com.devsuperior.movieflix.dtos.MoviePagedDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService services;
	
	
	@GetMapping
	public ResponseEntity<Page<MoviePagedDTO>> findAllPaged(Pageable pageable){
		Page<MoviePagedDTO> page =  services.findAllPaged(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping(value = "/genre")
	public ResponseEntity<Page<MoviePagedDTO>> findMovieByGenre(@RequestParam(required = false, defaultValue = "1")  Long idGenre, Pageable pageable){
		Page<MoviePagedDTO> page = services.findPagedByGenre(idGenre, pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id){
		MovieDetailsDTO dto = services.findByMovie(id);
		return ResponseEntity.ok(dto);
	}

}
