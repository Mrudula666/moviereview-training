package com.moviereviews.movieinfoservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moviereviews.movieinfoservice.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

}
