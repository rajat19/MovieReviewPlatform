package com.flipkart.test.model;

public class MovieReview {
    private User user;
    private Movie movie;
    private int rating;
    private UserLevel givenBy;

    public MovieReview(User user, Movie movie, int rating, UserLevel givenBy) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.givenBy = givenBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public UserLevel getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(UserLevel givenBy) {
        this.givenBy = givenBy;
    }

    @Override
    public String toString() {
        return "MovieReview{" +
                "user=" + user +
                ", movie=" + movie +
                ", rating=" + rating +
                ", givenBy=" + givenBy +
                '}';
    }
}
