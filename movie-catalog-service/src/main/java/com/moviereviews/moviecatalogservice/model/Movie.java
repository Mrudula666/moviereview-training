package com.moviereviews.moviecatalogservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Movie {

	private int movieId;
	private String movieTitle;
	private int releaseYear;
	private String movieCategory;
	private List<String> casts;

}
