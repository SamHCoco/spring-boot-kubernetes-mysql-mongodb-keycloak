package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.service.impl;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.model.Movie;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.repository.MovieRepository;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie getByMovieId(@NonNull String id) {
        return movieRepository.findByMovieId(id);
    }

    @Override
    public Movie save(@NonNull Movie movie) {
        if (!movieRepository.existsByMovieId(movie.getMovieId())) {
            return movieRepository.insert(movie);
        }
        return null;
    }

    @Override
    public Movie update(@NonNull Movie movie) {
        if (movieRepository.existsByMovieId(movie.getMovieId())) {
            return movieRepository.save(movie);
        }
        return null;
    }

    @Override
    public void deleteByMovieId(@NonNull String id) {
        movieRepository.deleteByMovieId(id);
    }
}
