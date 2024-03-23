package com.itmo.movies.repository;

import java.util.List;
import java.util.Optional;

import com.itmo.movies.model.movie.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findAll();
    Optional<Movie> findById(Integer id);
    Movie save(Movie movie);
    boolean existsById(Integer id);
    void deleteById(Integer id);
}
