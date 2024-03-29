package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.queue.MovieSender;
import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    private final MovieService service;
    @Autowired
    private  MovieSender movieSender;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@RequestParam String genre, @RequestParam(defaultValue = "false")
                                                Boolean throeError, HttpServletResponse response) {
        return ResponseEntity.ok().body(service.findByGenre(genre,throeError));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        movieSender.send(movie);
        return ResponseEntity.ok().body(service.save(movie));
    }
}
