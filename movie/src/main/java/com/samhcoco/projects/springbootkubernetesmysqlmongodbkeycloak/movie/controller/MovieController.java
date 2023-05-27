package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.controller;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.model.Movie;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private static final String VERSION = "api/v1";

    private final MovieService movieService;

    @GetMapping(VERSION + "/movie/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable String id) {
        val movie = movieService.getByMovieId(id);
        if (nonNull(movie)) {
            return new ResponseEntity<>(movie, OK);
        }
        return new ResponseEntity<>("Movie does not exist.", NOT_FOUND);
    }

    @PutMapping(VERSION + "/movie")
    public ResponseEntity<Object> updateMovie(@RequestBody Movie movie) {
        val updated = movieService.update(movie);
        if (nonNull(updated)) {
            return new ResponseEntity<>(updated, OK);
        }
        return new ResponseEntity<>("Movie does not exit.", BAD_REQUEST);
    }

    @PostMapping(VERSION + "/movie")
    public ResponseEntity<Object> saveMovie(@RequestBody Movie movie) {
        val created = movieService.save(movie);
        if (nonNull(created)) {
            return new ResponseEntity<>(created, OK);
        }
        return new ResponseEntity<>("Movie already exists.", BAD_REQUEST);
    }

    @DeleteMapping(VERSION + "/movie/{id}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable String id) {
        movieService.deleteByMovieId(id);
        return new ResponseEntity<>(OK);
    }

}
