package com.adel.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieRestController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.allmovies(),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieByImdbId(@PathVariable String id) {
	    try {
	        Movie movie = movieService.getMovieByImdbId(id);
	        return new ResponseEntity<>(movie, HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/{id}/reviews")
	public ResponseEntity<List<Review>> createReview(@PathVariable String id, @RequestBody Review review) {
		try {
			Review createdReview = reviewService.createReview(id, review.getBody());
			return new ResponseEntity<>(movieService.getMovieByImdbId(id).getReviewIds(), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
