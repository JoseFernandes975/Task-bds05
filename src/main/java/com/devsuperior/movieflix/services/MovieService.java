package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.MovieDetailsDTO;
import com.devsuperior.movieflix.dtos.MoviePagedDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Transactional(readOnly = true)
	public Page<MoviePagedDTO> findAllPaged(Pageable pageable){
		PageRequest request = PageRequest.of(0, 4, Sort.by("title"));
		Page<Movie> page = repository.findAll(request);
	    return page.map(x -> new MoviePagedDTO(x));
	}
	
	@Transactional(readOnly = true)
	public Page<MoviePagedDTO> findPagedByGenre(Long idGenre,Pageable pageable){
		PageRequest request = PageRequest.of(0, 4, Sort.Direction.ASC, "title", "genre");
		Genre genre = genreRepo.getOne(idGenre);
		Page<Movie> page = repository.findByGenre(genre, request);
		return page.map(x -> new MoviePagedDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public MovieDetailsDTO findByMovie(Long id) {
		Optional<Movie> optionalMovie = repository.findById(id);
		Movie entity = optionalMovie.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found!"));
		return new MovieDetailsDTO(entity);
      }
}