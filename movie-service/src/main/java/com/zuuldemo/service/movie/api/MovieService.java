package com.zuuldemo.service.movie.api;

import com.zuuldemo.service.movie.api.model.Movie;
import com.zuuldemo.service.movie.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/")
    public List<Movie> getAll() {
        log.info("Handling request for getAll()");
        return movieRepository.getMovies();
    }

    @RequestMapping("/{id}")
    public Movie get(@PathVariable("id") long id) throws Exception {
        log.info("Handling request for: get({})", id);
        Optional<Movie> movie = movieRepository.get(id);
        return movie.orElseThrow(() -> new Exception("Movie not found!"));
    }
}
