package com.api.movies.usecases;

import org.springframework.stereotype.Service;

import com.api.movies.domain.Movie;
import com.api.movies.domain.MovieRepository;

@Service
public class CreateMovieUseCase {
    private final MovieRepository movieRepository;

    public CreateMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(Movie movie) {
        return movieRepository.save(movie);        
    }
}
