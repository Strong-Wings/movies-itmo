package com.itmo.movies.controller;

import com.itmo.movies.model.movie.Movie;
import com.itmo.movies.model.movie.MovieListResponse;
import com.itmo.movies.model.movie.MovieResponse;
import com.itmo.movies.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
@Log4j2
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public MovieListResponse getMovies() {
        log.info("Get all movies");
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable int id) {
        log.info("Get movie by id {}", id);
        return movieService.getMovieById(id);
    }

    @PostMapping
    public MovieResponse createMovie(@RequestBody Movie movie) {
        log.info("Create movie {}", movie);
        return movieService.createMovie(movie);
    }

    @PatchMapping("/{id}")
    public MovieResponse updateMovieById(@PathVariable int id,
                                         @RequestBody Movie movie) {
        log.info("Update movie by id {}, {}", id, movie);
        return movieService.updateMovieById(id, movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable int id) {
        log.info("Delete movie by id {}", id);
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
