package com.flipkart.test.services;

import com.flipkart.test.model.Genre;
import com.flipkart.test.model.Movie;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    private final Map<String, Movie> movieMap;
    private static MovieService INSTANCE;

    private MovieService() {
        movieMap = new HashMap<>();
    }

    public static MovieService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieService();
        }
        return INSTANCE;
    }

    public void addMovie(String name, int releaseYear, List<Genre> genres) throws Exception {
        if (movieMap.containsKey(name)) {
            System.out.println("movie already created");
            return;
        }
        Movie movie = new Movie(name, releaseYear, genres);
        movieMap.put(name, movie);

        System.out.println("Added new movie: "+name);
    }

    public Movie getMovie(String movieName) {
        if (movieMap.containsKey(movieName)) {
            return movieMap.get(movieName);
        }
        return null;
    }
}
