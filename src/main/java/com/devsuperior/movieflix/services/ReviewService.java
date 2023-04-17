package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.ReviewSaveDTO;
import com.devsuperior.movieflix.dtos.ReviewInsertDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private AuthService serviceAuth;
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepo;
	

	@Transactional
	@PreAuthorize("hasAnyRole('MEMBER')")
    public void saveReview(Long id, ReviewSaveDTO dto) {
    	Review entity = repository.getOne(id);
       User user = serviceAuth.authenticated();
        serviceAuth.validateUserIsMemberAndSelf(user.getId());
    	entity.setText(dto.getText());
    	repository.save(entity);
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('MEMBER')")
	public ReviewInsertDTO insertReview(ReviewInsertDTO dto) {
		User user = serviceAuth.authenticated();
	    
		Review entity = new Review();
		entity.setText(dto.getText());
		entity.setUser(user);
		Movie movie = movieRepo.getOne(dto.getMovieId());
		entity.setMovie(movie);
		repository.save(entity); 
		return new ReviewInsertDTO(entity);
	}
	

}
