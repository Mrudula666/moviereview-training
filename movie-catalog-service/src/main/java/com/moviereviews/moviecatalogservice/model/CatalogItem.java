package com.moviereviews.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CatalogItem {

	private Movie movie;
	private int rating;

}
