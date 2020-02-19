package com.moviereviews.movieratingservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moviereviews.movieratingservice.model.UserRating;

public interface UserRepository extends MongoRepository<UserRating, String> {

}
