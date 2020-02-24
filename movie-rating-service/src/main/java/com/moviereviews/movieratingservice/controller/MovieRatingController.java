package com.moviereviews.movieratingservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviews.movieratingservice.model.UserRating;
import com.moviereviews.movieratingservice.repo.UserRepository;

@RestController
@RequestMapping("/movieratings")
public class MovieRatingController {

	@Autowired
	private Environment environment;

	private static final Logger logger = LoggerFactory.getLogger(MovieRatingController.class);
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users/{userId}/ratings")
	public ResponseEntity<UserRating> getMovieRatings(@PathVariable("userId") String userId) {

		logger.info("current environment >>>>>> " + environment.getProperty("app.env"));
		Optional<UserRating> ratingsList = userRepository.findById(userId);

		ResponseEntity<UserRating> response = null;

		if (ratingsList.isPresent())
			response = new ResponseEntity<UserRating>(ratingsList.get(), HttpStatus.OK);
		else
			response = new ResponseEntity<UserRating>(HttpStatus.NOT_FOUND);
		return response;

	}

}
