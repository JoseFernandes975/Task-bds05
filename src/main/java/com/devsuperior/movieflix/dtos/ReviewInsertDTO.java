package com.devsuperior.movieflix.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Review;

public class ReviewInsertDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Size(min = 3, max = 40, message = "Deve ter entre 5 a 40 caracteres")
	private String text;
	private Long movieId;
	private Long userId;
	
	public ReviewInsertDTO() {
	}

	public ReviewInsertDTO(Long id, String text, Long movieId, Long userId) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.userId = userId;
	}
	
	public ReviewInsertDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		userId = entity.getUser().getId();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewInsertDTO other = (ReviewInsertDTO) obj;
		return Objects.equals(id, other.id);
	}

}
