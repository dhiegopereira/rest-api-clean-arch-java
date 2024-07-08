package com.api.movies.adapters.controllers;

import com.api.movies.domain.Movie;
import com.api.movies.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final CreateMovieUseCase createMovieUseCase;
    private final ReadAllMoviesUseCase readAllMoviesUseCase;

    public MovieController(CreateMovieUseCase createMovieUseCase,
                           ReadAllMoviesUseCase readAllMoviesUseCase) {
        this.createMovieUseCase = createMovieUseCase;
        this.readAllMoviesUseCase = readAllMoviesUseCase;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = createMovieUseCase.execute(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = readAllMoviesUseCase.execute();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
