package com.moviereviews.movieinfoservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviews.movieinfoservice.model.Movie;
import com.moviereviews.movieinfoservice.repo.MovieRepository;

@RestController
public class MovieController {

	@Autowired
	private Environment environment;

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> getMovies(@PathVariable int movieId) {
		logger.info("current environment >>>>>>> " + environment.getProperty("app.env"));
		Optional<Movie> movieDetails = movieRepository.findById(movieId);
		ResponseEntity<Movie> response = null;
		if (movieDetails.isPresent()) {
			response = new ResponseEntity<Movie>(movieDetails.get(), HttpStatus.OK);
		} else
			response = new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		return response;
	}

}
