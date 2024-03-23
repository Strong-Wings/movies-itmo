package com.itmo.movies.service;

import com.itmo.movies.model.director.Director;
import com.itmo.movies.model.director.DirectorListResponse;
import com.itmo.movies.model.director.DirectorResponse;

public interface DirectorService {
    DirectorListResponse getDirectors();

    DirectorResponse getDirectorById(int id);

    DirectorResponse createDirector(Director Director);

    DirectorResponse updateDirectorById(int id, Director Director);

    void deleteDirectorById(int id);
}
