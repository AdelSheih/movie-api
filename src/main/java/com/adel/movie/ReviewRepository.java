package com.adel.movie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
	
	// Additional query methods can be defined here if needed
	// For example, to find reviews by a specific field:
	// List<Review> findByMovieId(String movieId);


}