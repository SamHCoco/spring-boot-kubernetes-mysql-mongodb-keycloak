package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.movie.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movie")
public class Movie {
    @Id
    String movieId;
    private String title;
    private String director;
    private String genre;
    private short releaseYear;
}
