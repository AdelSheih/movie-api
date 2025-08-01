package com.adel.movie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

	Optional<Movie> findByImdbId(String id);

	List<Movie> findByTitleContainingIgnoreCase(String title);
}