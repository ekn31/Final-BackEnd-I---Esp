package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.client.IMovieServiceClient;
import com.dh.catalogservice.client.ISerieServiceClient;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final IMovieServiceClient iMovieServiceClient;
    private final ISerieServiceClient iSerieServiceClient;

    @GetMapping("/movie/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
        return  iMovieServiceClient.getMovieByGenre(genre);
    }

    @GetMapping("/series/{genre}")
    ResponseEntity<List<Serie>> getGender(@PathVariable String genre){
        return iSerieServiceClient.getSerieByGenre(genre);

}
}
