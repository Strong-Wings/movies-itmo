package com.itmo.movies.repository;

import java.util.List;
import java.util.Optional;

import com.itmo.movies.model.director.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {
    List<Director> findAll();
    Optional<Director> findById(Integer id);
    Director save(Director movie);
    boolean existsById(Integer id);
    void deleteById(Integer id);
}
