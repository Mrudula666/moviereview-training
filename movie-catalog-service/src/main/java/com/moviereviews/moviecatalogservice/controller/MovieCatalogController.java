package com.moviereviews.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.moviereviews.moviecatalogservice.model.CatalogItem;
import com.moviereviews.moviecatalogservice.model.Movie;
import com.moviereviews.moviecatalogservice.model.MovieCatalog;
import com.moviereviews.moviecatalogservice.model.Rating;
import com.moviereviews.moviecatalogservice.model.UserRating;
import com.moviereviews.moviecatalogservice.proxy.MovieInfoServiceProxy;
import com.moviereviews.moviecatalogservice.proxy.MovieRatingServiceProxy;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {

	@Autowired
	private Environment environment;

	private static final Logger logger = LoggerFactory.getLogger(MovieCatalogController.class);

	@Autowired
	private MovieInfoServiceProxy movieInfoServiceProxy;

	@Autowired
	private MovieRatingServiceProxy movieRatingServiceProxy;

	private CatalogItem catalogItem = null;
	private MovieCatalog movieCatalog = null;
	ResponseEntity<MovieCatalog> movieCatalogEntity = null;

	@GetMapping("/catalog-feign/{userId}")
	public ResponseEntity<MovieCatalog> getMovieCatalogUsingFeignClient(@PathVariable("userId") String userId) {

		logger.info("current environment >>> " + environment.getProperty("app.env"));
		UserRating userRating = movieRatingServiceProxy.getUserRatings(userId).getBody();
		List<Rating> ratings = userRating.getRatings();

		for (Rating rating : ratings) {
			int movieId = rating.getMovieId();
			Movie movie = movieInfoServiceProxy.getMovieDetails(movieId).getBody();
			catalogItem = new CatalogItem(movie, rating.getRating());
			List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
			catalogItems.add(catalogItem);
			movieCatalog = new MovieCatalog(userId, catalogItems);
			movieCatalogEntity = new ResponseEntity<MovieCatalog>(movieCatalog, HttpStatus.OK);
		}
		return movieCatalogEntity;

	}

}
