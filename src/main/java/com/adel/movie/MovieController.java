package com.adel.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/")
	public String showMovies(Model model, String search) {
		List<Movie> movies;
		if (search != null && !search.isEmpty()) {
			// You may want to implement a search method in MovieService
			movies = movieService.searchMovies(search);
		} else {
			movies = movieService.allmovies();
		}
		model.addAttribute("movies", movies);
		model.addAttribute("search", search);
		return "movies";
	}

	@GetMapping("/movies/{imdbId}")
	public String movieDetails(@PathVariable String imdbId, Model model) {
		Movie movie = movieService.getMovieByImdbId(imdbId);
		List<Review> reviews = movie.getReviewIds(); // Assuming reviewIds is List<Review>
		model.addAttribute("movie", movie);
		model.addAttribute("reviews", reviews);
		return "movie-details";
	}

	@PostMapping("/movies/{imdbId}/reviews")
	public String addReview(@PathVariable String imdbId, @RequestParam("body") String body, Model model) {
		reviewService.createReview(imdbId, body);
		return "redirect:/movies/" + imdbId;
	}

	@PostMapping("/movies/{imdbId}/rate")
	public String rateMovie(@PathVariable String imdbId, @RequestParam("rating") int rating) {
		movieService.addRating(imdbId, rating);
		return "redirect:/movies/" + imdbId;
	}

}