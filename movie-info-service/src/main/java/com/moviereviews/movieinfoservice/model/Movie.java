package com.moviereviews.movieinfoservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@Document(collection = "movies")
public class Movie {

	@Id
	private int movieId;
	private String movieTitle;
	private int releaseYear;
	private String movieCategory;
	private List<String> casts;

}
