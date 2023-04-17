package com.devsuperior.movieflix.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.devsuperior.movieflix.entities.Movie;

public class MoviePagedDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String subTitle;
	@NotNull(message = "Filme deve conter o ano!")
	private Integer year;
	private String imgUrl;
	
	
	public MoviePagedDTO() {
	}

	public MoviePagedDTO(String title, String subTitle, Integer year, String imgUrl) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
	}
	
	public MoviePagedDTO(Movie entity) {
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
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
	
	

}
