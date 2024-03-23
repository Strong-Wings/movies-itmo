package com.itmo.movies.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itmo.movies.model.director.Director;
import com.itmo.movies.model.movie.Movie;

public class ValidationUtils {

    public static void validate(Movie movie) {
        List<String> messages = new ArrayList<>();
        messages.addAll(getDirectorMessages(movie.getDirector()));
        if (movie.getTitle() == null || movie.getTitle().length() > 100) {
            messages.add("Invalid title: not in [0-100] symbols");
        }
        if (movie.getYear() < 1900 || movie.getYear() > 2100) {
            messages.add("Invalid year: not in [1900-2100]");
        }
        if (movie.getLength() == null) {
            messages.add("Invalid length: not in [hh:mm:ss]");
        }
        if (movie.getRating() < 0 || movie.getRating() > 10) {
            messages.add("Invalid rating: not in [0-10]");
        }
        if (messages.size() != 0) {
            throw new IllegalArgumentException(String.join(", ", messages));
        }
    }

    public static void validate(Director director) {
        var messages = getDirectorMessages(director);
        if (messages.size() != 0) {
            throw new IllegalArgumentException(String.join(", ", messages));
        }
    }

    private static List<String> getDirectorMessages(Director director) {
        if (director.getFio() == null || director.getFio().length() > 100) {
            return List.of("Invalid fio: not in [0-100] symbols");
        }
        return Collections.emptyList();
    }
}
