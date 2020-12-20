package com.paradox.geek.services;

import com.paradox.geek.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class ReviewService {
    private final List<MovieReview> movieReviewList;
    private final UserService userService;
    private final MovieService movieService;

    public ReviewService() {
        this.movieReviewList = new ArrayList<>();
        this.userService = UserService.getInstance();
        this.movieService = MovieService.getInstance();
    }

    public MovieReview findMovieByUserAndMovie(String userName, String movieName) {
        for(MovieReview movieReview: this.movieReviewList) {
            if (movieReview.getMovie().getMovieName().equals(movieName) && movieReview.getUser().getName().equals(userName)) {
                return movieReview;
            }
        }
        return null;
    }

    public void getTopKMoviesByYear(int year, int count, UserLevel userLevel) {
        Map<Movie, Integer> totalRatings = new HashMap<>();
        for(MovieReview movieReview: movieReviewList) {
            Movie movie = movieReview.getMovie();
            if (movieReview.getGivenBy() == userLevel && movie.getReleaseYear() == year) {
                totalRatings.put(movie, totalRatings.getOrDefault(movie, 0) + movieReview.getRating());
            }
        }
        Map<Movie,Integer> topK =
                totalRatings.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(count)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.printf("Top %d movies by rating by %s for year %d are: \n", count, userLevel, year);
        topK.forEach((k, v) -> {
            System.out.printf("Movie: %s Rating: %d\n", k.getMovieName(), v);
        });
    }

    public void getTopMovieByGenre(Genre genre, int count) {
        Map<Movie, Integer> totalRatings = new HashMap<>();
        for(MovieReview movieReview: movieReviewList) {
            Movie movie = movieReview.getMovie();
            User user = movieReview.getUser();
            if (user.getLevel() == UserLevel.VIEWER && movie.getGenres().contains(genre)) {
                totalRatings.put(movie, totalRatings.getOrDefault(movie, 0) + movieReview.getRating());
            }
        }
        Map<Movie,Integer> topK =
                totalRatings.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(count)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.printf("Top %d movies for genre %s are: \n", count, genre);
        topK.forEach((k, v) -> {
            System.out.printf("Movie: %s Rating: %d\n", k.getMovieName(), v);
        });
    }

    public void addReview(String userName, String movieName, int rating) {
        if (findMovieByUserAndMovie(userName, movieName) != null) {
            System.out.printf("Review already exist for movie %s by user %s\n", movieName, userName);
            return;
        }
        if (rating < 1 || rating > 10) {
            System.out.println("Rating should be in range 1 to 10");
            return;
        }
        Movie movie = movieService.getMovie(movieName);
        if (movie == null) {
            System.out.printf("movie %s doesn't exist\n", movieName);
            return;
        }
        int currentYear = new Date().getYear() + 1900;
        if (movie.getReleaseYear() > currentYear) {
            System.out.printf("Review cannot be added for future movie %s\n", movieName);
            return;
        }
        User user = userService.getUser(userName);
        if (user == null) {
            System.out.printf("user %s doesn't exist\n", userName);
            return;
        }
        MovieReview movieReview = new MovieReview(user, movie, rating, user.getLevel());
        user.setReviewCount(user.getReviewCount() + 1);
        UserService.updateUserLevelIfEligible(user);
        movieReviewList.add(movieReview);

        System.out.println("Review added for user: "+userName+" and movie: "+movieName);
    }
}
