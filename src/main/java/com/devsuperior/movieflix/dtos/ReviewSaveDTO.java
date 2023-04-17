package com.devsuperior.movieflix.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Review;

public class ReviewSaveDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    @NotBlank(message = "Texto não deve ser vazio! Adicione um texto a avaliação!")
	private String text;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	public ReviewSaveDTO() {
	}

	public ReviewSaveDTO(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	public ReviewSaveDTO(Review entity) {
	  id = entity.getId();
	  text = entity.getText();
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
		ReviewSaveDTO other = (ReviewSaveDTO) obj;
		return Objects.equals(id, other.id);
	}
}
