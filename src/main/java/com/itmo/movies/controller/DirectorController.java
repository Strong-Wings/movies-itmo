package com.itmo.movies.controller;

import com.itmo.movies.model.director.Director;
import com.itmo.movies.model.director.DirectorListResponse;
import com.itmo.movies.model.director.DirectorResponse;
import com.itmo.movies.service.DirectorService;
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
@RequestMapping("/director")
@AllArgsConstructor
@Log4j2
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping
    public DirectorListResponse getDirectors() {
        log.info("Get all directors");
        return directorService.getDirectors();
    }

    @GetMapping("/{id}")
    public DirectorResponse getDirectorById(@PathVariable int id) {
        log.info("Get director by id {}", id);
        return directorService.getDirectorById(id);
    }

    @PostMapping
    public DirectorResponse createDirector(@RequestBody Director director) {
        log.info("Create director {}", director);
        return directorService.createDirector(director);
    }

    @PatchMapping("/{id}")
    public DirectorResponse updateDirectorById(@PathVariable int id,
                                               @RequestBody Director director) {
        log.info("Update director by id {}, {}", id, director);
        return directorService.updateDirectorById(id, director);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectorById(@PathVariable int id) {
        log.info("Delete director by id {}", id);
        directorService.deleteDirectorById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
