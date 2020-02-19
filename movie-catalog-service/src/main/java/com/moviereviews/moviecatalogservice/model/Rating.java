package com.moviereviews.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rating {
	private int movieId;
	private int rating;

}
