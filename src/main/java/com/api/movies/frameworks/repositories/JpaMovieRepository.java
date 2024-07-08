package com.api.movies.frameworks.repositories;

import com.api.movies.domain.Movie;
import com.api.movies.domain.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovieRepository extends JpaRepository<Movie, Long>, MovieRepository {
}
