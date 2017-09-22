package com.zuuldemo.service.movie.repository;

import com.zuuldemo.service.movie.api.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        this.movies.add(new Movie(1L, "Dunkirk", 2017, "war", 9));
        this.movies.add(new Movie(2L, "Pirates of the Caribbean: Dead Men Tell No Tales", 2017, "adventure", 6));
        this.movies.add(new Movie(3L, "Wonder Woman", 2017, "action", 8));
        this.movies.add(new Movie(4L, "Guardians of the Galaxy", 2014, "adventure", 8));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Optional<Movie> get(final long id) {
        return movies.stream().filter(movie -> movie.getId() == id).findFirst();
    }
}
