package com.api.movies.usecases;

import com.api.movies.domain.Movie;
import com.api.movies.domain.MovieRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReadAllMoviesUseCase {
    private final MovieRepository movieRepository;

    public ReadAllMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute() {
        return movieRepository.findAll();
    }
}
