package com.dh.catalogservice.api.controller;


import com.dh.catalogservice.api.service.OffLineService;
import com.dh.catalogservice.client.IMovieServiceClient;
import com.dh.catalogservice.client.ISerieServiceClient;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.OffLine;
import com.dh.catalogservice.domain.model.Serie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    OffLineService offLineService;


    @CircuitBreaker(name="MovieService", fallbackMethod = "fallBackMovieService")
    @GetMapping("/movie/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
        return  iMovieServiceClient.getMovieByGenre(genre);
    }

    @GetMapping("/series/{genre}")
    ResponseEntity<List<Serie>> getGender(@PathVariable String genre){
        return iSerieServiceClient.getSerieByGenre(genre);

}

    @GetMapping("/OffLine/{genre}")
    List<OffLine> Gender(@PathVariable String genre){
        return offLineService.Offline(genre);

    }

   private ResponseEntity<List<Movie>> fallBackMovieService (@PathVariable String genre, RuntimeException e) {
      return new ResponseEntity("Por el momento no es posible consultar el genero: " + genre + ". Por favor intente mas tarde", org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
    }
}
