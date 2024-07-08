package com.api.movies.adapters;

import com.api.movies.adapters.controllers.MovieController;
import com.api.movies.domain.Movie;
import com.api.movies.usecases.CreateMovieUseCase;
import com.api.movies.usecases.ReadAllMoviesUseCase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateMovieUseCase createMovieUseCase;

    @MockBean
    private ReadAllMoviesUseCase readAllMoviesUseCase;

    public MovieControllerTest(@Autowired ReadAllMoviesUseCase readAllMoviesUseCase,
                               @Autowired CreateMovieUseCase createMovieUseCase) {
        this.readAllMoviesUseCase = readAllMoviesUseCase;
        this.createMovieUseCase = createMovieUseCase;
    }

    @Test
    void shouldCreateMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setYear(2010);
        when(createMovieUseCase.execute(any(Movie.class))).thenReturn(movie);

        mockMvc.perform(post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Inception\",\"genre\":\"Sci-Fi\",\"year\":2010}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Inception"))
                .andExpect(jsonPath("$.genre").value("Sci-Fi"))
                .andExpect(jsonPath("$.year").value(2010));
    }

    @Test
    void shouldGetAllMovies() throws Exception {
        Movie m1 = new Movie();
        m1.setTitle("Inception");
        m1.setGenre("Sci-Fi");
        m1.setYear(2010);

        Movie m2 = new Movie();
        m2.setTitle("Interstellar");
        m2.setGenre("Sci-Fi");
        m2.setYear(2014);

        List<Movie> movies = Arrays.asList(m1, m2);

        when(readAllMoviesUseCase.execute()).thenReturn(movies);

        mockMvc.perform(get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Inception"))
                .andExpect(jsonPath("$[0].genre").value("Sci-Fi"))
                .andExpect(jsonPath("$[0].year").value(2010))
                .andExpect(jsonPath("$[1].title").value("Interstellar"))
                .andExpect(jsonPath("$[1].genre").value("Sci-Fi"))
                .andExpect(jsonPath("$[1].year").value(2014));
    }
}
