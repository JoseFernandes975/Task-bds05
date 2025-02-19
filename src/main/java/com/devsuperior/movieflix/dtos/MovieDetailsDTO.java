package com.devsuperior.movieflix.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDetailsDTO {

	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	@Size(min = 3, max = 100, message = "A sinopse deve conter entre 3 a 100 caracteres!")
	private String synopsis;
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	public MovieDetailsDTO() {
	}

	public MovieDetailsDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieDetailsDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		synopsis = entity.getSynopsis();
		
		for(Review x: entity.getReviews()) {
			reviews.add(new ReviewDTO(x));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}
}
