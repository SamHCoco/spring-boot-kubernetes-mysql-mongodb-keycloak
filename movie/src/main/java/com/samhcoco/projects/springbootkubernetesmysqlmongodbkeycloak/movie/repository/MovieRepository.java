package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.repository;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findByMovieId(String movieId);

    boolean existsByMovieId(String movieId);

    void deleteByMovieId(String movieId);

}
