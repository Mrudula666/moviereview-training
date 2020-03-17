package com.moviereviews.movieratingservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Document(collection = "userratings")
public class UserRating {
	@Id
	private String userId;
	private List<Rating> ratings;

}
