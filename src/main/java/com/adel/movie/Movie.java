package com.adel.movie;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	private String trailerLink;
	private String poster;
	private List<String> genres;
	private List<String> backdrops; 
	private List<Review> reviewIds;
	private List<Integer> ratings; // List of ratings (1-5 stars)
	
	public double getAverageRating() {
		if (ratings == null || ratings.isEmpty()) return 0.0;
		return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
	}
	public int getRatingCount() {
		return ratings == null ? 0 : ratings.size();
	}

}