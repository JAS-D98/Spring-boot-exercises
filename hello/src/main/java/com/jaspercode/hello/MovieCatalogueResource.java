package com.jaspercode.hello;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {
    
    @GetMapping("/{userId}")
    public List<CatalogueItem> getCatalogue(@PathVariable("userId") String userId){

        return Collections.singletonList(
            new CatalogueItem("transformers", "Test", 4)
        );
    }

    @GetMapping("/movie/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId){
        return new MovieInfo("Jasper");
    }
}
