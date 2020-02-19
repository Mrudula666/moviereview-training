package com.moviereviews.moviecatalogservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviereviews.moviecatalogservice.model.UserRating;

@FeignClient(name = "movie-rating-service")
@RibbonClient(name = "movie-rating-service")
public interface MovieRatingServiceProxy {

	@GetMapping("/movieratings/users/{userId}/ratings")
	public ResponseEntity<UserRating> getUserRatings(@PathVariable("userId") String userId);

}
