package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
    private String text;

    public ReviewDTO() {
    }

	public ReviewDTO(Long id, String userName, String text) {
		super();
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	public ReviewDTO(Review entity) {
		id = entity.getId();
		userName = entity.getUser().getName();
		text = entity.getText();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
}
