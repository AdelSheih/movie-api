package com.adel.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	public List<Movie> allmovies() {
		List<Movie> movies = movieRepository.findAll();
		System.out.println("Number of movies found: " + movies.size());
		 for (int i = 0; i < movies.size(); i++) {
	            Movie movie = movies.get(i);
	            System.out.println("Movie " + i + ":");
	            System.out.println("  ID: " + movie.getId());
	            System.out.println("  Title: " + movie.getTitle());
	            System.out.println("  IMDB ID: " + movie.getImdbId());
	            System.out.println("  Release Date: " + movie.getReleaseDate());
	            System.out.println("  Genres: " + movie.getGenres());
	        }
		
		
		return movies;
		
	}

}
