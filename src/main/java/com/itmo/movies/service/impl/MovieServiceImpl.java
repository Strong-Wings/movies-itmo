package com.itmo.movies.service.impl;

import java.util.NoSuchElementException;

import com.itmo.movies.model.movie.Movie;
import com.itmo.movies.model.movie.MovieListResponse;
import com.itmo.movies.model.movie.MovieResponse;
import com.itmo.movies.repository.MovieRepository;
import com.itmo.movies.service.MovieService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.itmo.movies.utils.ValidationUtils.validate;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieListResponse getMovies() {
        var movies = movieRepository.findAll();
        return MovieListResponse.builder()
                .list(movies)
                .build();
    }

    @Override
    public MovieResponse getMovieById(int id) {
        validateExistenceById(id);
        var movie = movieRepository.findById(id).get();
        return MovieResponse.builder()
                .movie(movie)
                .build();
    }

    @Override
    public MovieResponse createMovie(Movie movie) {
        validate(movie);
        movieRepository.save(movie);
        return MovieResponse.builder()
                .movie(movie)
                .build();
    }

    @Override
    @Transactional
    public MovieResponse updateMovieById(int id, Movie movie) {
        validate(movie);
        validateExistenceById(id);
        movie.setId(id);
        movieRepository.save(movie);
        return MovieResponse.builder()
                .movie(movie)
                .build();
    }

    @Override
    @Transactional
    public void deleteMovieById(int id) {
        validateExistenceById(id);
        movieRepository.deleteById(id);
    }

    private void validateExistenceById(int id) {
        if (!movieRepository.existsById(id)) {
            throw new NoSuchElementException("No movie found by id");
        }
    }
}
