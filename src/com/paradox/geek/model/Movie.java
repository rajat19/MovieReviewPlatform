package com.paradox.geek.model;

import java.util.List;

public class Movie {
    private String movieName;
    private int releaseYear;
    private List<Genre> genres;

    public Movie(String movieName, int releaseYear, List<Genre> genres) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.genres = genres;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                '}';
    }
}
