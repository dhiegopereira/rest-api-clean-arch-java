package com.api.movies.domain;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Movie save(Movie movie);
    List<Movie> findAll();
}
