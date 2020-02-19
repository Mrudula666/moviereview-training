package com.moviereviews.moviecatalogservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MovieCatalog {

	private String userId;
	private List<CatalogItem> catalogItems;

}
