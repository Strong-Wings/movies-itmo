package com.itmo.movies.service;

import com.itmo.movies.model.movie.Movie;
import com.itmo.movies.model.movie.MovieListResponse;
import com.itmo.movies.model.movie.MovieResponse;

public interface MovieService {
    MovieListResponse getMovies();

    MovieResponse getMovieById(int id);

    MovieResponse createMovie(Movie movie);

    MovieResponse updateMovieById(int id, Movie movie);

    void deleteMovieById(int id);
}
