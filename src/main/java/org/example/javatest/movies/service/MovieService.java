package org.example.javatest.movies.service;

import org.example.javatest.movies.data.MovieRepository;
import org.example.javatest.movies.model.Genre;
import org.example.javatest.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : repository.findAll()) {
            if (movie.getGenre() == genre) {
                list.add(movie);
            }
        }
        return list;
    }

    public Collection<Movie> findMoviesByLength(int duration) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : repository.findAll()) {
            if (movie.getMinutes() <= duration) {
                list.add(movie);
            }
        }
        return list;
    }

    public Collection<Movie> findMoviesByName(String name) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : repository.findAll()) {
            if (movie.getName().toLowerCase().contains(name)) {
                list.add(movie);
            }
        }
        return list;
    }

    public Collection<Movie> findMoviesByDirector(String nameDirector) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : repository.findAll()) {
            if (movie.getDirector().toLowerCase().contains(nameDirector)) {
                list.add(movie);
            }
        }
        return list;
    }

    public Collection<Movie> findMoviesByTemplate(Movie templateMovie) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : repository.findAll()) {
            if (templateMovie.getName() != null) {
                if (movie.getName().toLowerCase().contains(templateMovie.getName())) {
                    if (!list.contains(movie)) {
                        list.add(movie);
                    }
                }
            }
            if (templateMovie.getMinutes() != null) {
                if (movie.getMinutes() <= templateMovie.getMinutes()) {
                    if (!list.contains(movie)) {
                        list.add(movie);
                    }
                }
            }
            if (templateMovie.getGenre() != null) {
                if (movie.getGenre().toString().equals(templateMovie.getGenre().toString())) {
                    if (!list.contains(movie)) {
                        list.add(movie);
                    }
                }
            }
            if (templateMovie.getDirector() != null) {
                if (movie.getDirector().toLowerCase().equals(templateMovie.getDirector())) {
                    if (!list.contains(movie)) {
                        list.add(movie);
                    }
                }
            }
        }
        return list;
    }
}