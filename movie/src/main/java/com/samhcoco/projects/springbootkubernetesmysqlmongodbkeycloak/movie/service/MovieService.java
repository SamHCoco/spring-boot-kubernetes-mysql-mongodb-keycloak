package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.service;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.model.Movie;

public interface MovieService {

    Movie getByMovieId(String id);

    Movie save(Movie movie);

    Movie update(Movie movie);

    void deleteByMovieId(String id);

}
