package com.itmo.movies.service.impl;

import java.util.NoSuchElementException;

import com.itmo.movies.model.director.Director;
import com.itmo.movies.model.director.DirectorListResponse;
import com.itmo.movies.model.director.DirectorResponse;
import com.itmo.movies.repository.DirectorRepository;
import com.itmo.movies.service.DirectorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.itmo.movies.utils.ValidationUtils.validate;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public DirectorListResponse getDirectors() {
        var directors = directorRepository.findAll();
        return DirectorListResponse.builder()
                .list(directors)
                .build();
    }

    @Override
    @Transactional
    public DirectorResponse getDirectorById(int id) {
        validateExistenceById(id);
        var director = directorRepository.findById(id).get();
        return DirectorResponse.builder()
                .director(director)
                .build();
    }

    @Override
    public DirectorResponse createDirector(Director director) {
        validate(director);
        directorRepository.save(director);
        return DirectorResponse.builder()
                .director(director)
                .build();
    }

    @Override
    @Transactional
    public DirectorResponse updateDirectorById(int id, Director director) {
        validate(director);
        validateExistenceById(id);
        director.setId(id);
        directorRepository.save(director);
        return DirectorResponse.builder()
                .director(director)
                .build();
    }

    @Override
    @Transactional
    public void deleteDirectorById(int id) {
        validateExistenceById(id);
        directorRepository.deleteById(id);
    }

    private void validateExistenceById(int id) {
        if (!directorRepository.existsById(id)) {
            throw new NoSuchElementException("No director found by id");
        }
    }
}
