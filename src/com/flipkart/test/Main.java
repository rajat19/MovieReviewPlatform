package com.flipkart.test;

import com.flipkart.test.model.Genre;
import com.flipkart.test.model.UserLevel;
import com.flipkart.test.services.MovieService;
import com.flipkart.test.services.ReviewService;
import com.flipkart.test.services.UserService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            MovieService movieService = MovieService.getInstance();
            movieService.addMovie("Don", 2006, Arrays.asList(Genre.ACTION, Genre.COMEDY));
            movieService.addMovie("Tiger", 2008, Arrays.asList(Genre.DRAMA));
            movieService.addMovie("Padmaavat", 2006, Arrays.asList(Genre.COMEDY));
            movieService.addMovie("Lunchbox-2", 2021, Arrays.asList(Genre.DRAMA));
            movieService.addMovie("Guru", 2006, Arrays.asList(Genre.DRAMA));
            movieService.addMovie("Metro", 2016, Arrays.asList(Genre.ROMANCE));

            UserService userService = UserService.getInstance();
            userService.addUser("SRK");
            userService.addUser("Salman");
            userService.addUser("Deepika");

            ReviewService reviewService = new ReviewService();
            reviewService.addReview("SRK", "Don", 2);
            reviewService.addReview("SRK", "Padmaavat", 8);
            reviewService.addReview("Deepika", "Don", 9);
            reviewService.addReview("Salman", "Don", 5);
            reviewService.addReview("Deepika", "Guru", 6);
            reviewService.addReview("SRK", "Don", 10);
            reviewService.addReview("Deepika", "Lunchbox-2", 6);
            reviewService.addReview("SRK", "Tiger", 5);
            reviewService.addReview("SRK", "Metro", 7);

            reviewService.getTopKMoviesByYear(2006, 1, UserLevel.VIEWER);
            reviewService.getTopKMoviesByYear(2016, 1, UserLevel.CRITIC);
            reviewService.getTopMovieByGenre(Genre.DRAMA, 1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
