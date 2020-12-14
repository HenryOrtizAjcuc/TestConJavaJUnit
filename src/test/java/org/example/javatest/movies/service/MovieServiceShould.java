package org.example.javatest.movies.service;

import org.example.javatest.movies.data.MovieRepository;
import org.example.javatest.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.javatest.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION, "director1"),
                        new Movie(2, "Memento", 113, THRILLER, "directo2"),
                        new Movie(3, "There's Something About Mary", 119, COMEDY, "director3"),
                        new Movie(4, "Super 8", 112, THRILLER, "director4"),
                        new Movie(5, "Scream", 111, HORROR, "director5"),
                        new Movie(6, "Home Alone", 120, COMEDY, "director6"),
                        new Movie(7, "Matrix", 136, ACTION, "director7"),
                        new Movie(8, "Matrix 2", 160, ACTION, "director7")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(getMoviesIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMoviesIds(movies), is(Arrays.asList(2, 3, 4, 5)));
    }

    @Test
    public void return_movies_by_name() {
        Collection<Movie> movies = movieService.findMoviesByName("matri");
        assertThat(getMoviesIds(movies), is(Arrays.asList(7, 8)));
    }

    @Test
    public void return_movies_by_director() {
        Collection<Movie> movies = movieService.findMoviesByDirector("director7");
        assertThat(getMoviesIds(movies), is(Arrays.asList(7, 8)));
    }

    @Test
    public void return_movies_by_template() {
        Movie template = new Movie(null, 111, HORROR, null);
        Collection<Movie> movies = movieService.findMoviesByTemplate(template);
        assertThat(getMoviesIds(movies), is(Arrays.asList(5)));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}