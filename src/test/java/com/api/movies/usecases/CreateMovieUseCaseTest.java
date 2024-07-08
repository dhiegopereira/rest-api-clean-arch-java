package com.api.movies.usecases;

import com.api.movies.domain.Movie;
import com.api.movies.domain.MovieRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CreateMovieUseCaseTest {

    @Test
    void shouldCreateMovie() {
        MovieRepository repository = mock(MovieRepository.class);
        CreateMovieUseCase createMovieUseCase = new CreateMovieUseCase(repository);
        
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setYear(2010);

        when(repository.save(movie)).thenReturn(movie);
        
        Movie createdMovie = createMovieUseCase.execute(movie);
        
        assertNotNull(createdMovie);
        assertEquals("Inception", createdMovie.getTitle());
        verify(repository).save(movie);
    }
}