package com.api.movies.usecases;

import com.api.movies.domain.Movie;
import com.api.movies.domain.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReadAllMoviesUseCaseTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private ReadAllMoviesUseCase readAllMoviesUseCase;

    @Test
    void shouldReturnAllMovies() {
        Movie m1 = new Movie();
        m1.setTitle("Inception");
        m1.setGenre("Sci-Fi");
        m1.setYear(2010);

        Movie m2 = new Movie();
        m2.setTitle("Interstellar");
        m2.setGenre("Sci-Fi");
        m2.setYear(2014);

        List<Movie> movies = Arrays.asList(
                m1,
                m2
        );

        when(movieRepository.findAll()).thenReturn(movies);
        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> result = readAllMoviesUseCase.execute();

        assertEquals(movies.size(), result.size());
        assertEquals(movies.get(0).getTitle(), result.get(0).getTitle());
        assertEquals(movies.get(1).getTitle(), result.get(1).getTitle());
    }
}
