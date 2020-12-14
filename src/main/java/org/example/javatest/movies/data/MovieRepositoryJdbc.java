package org.example.javatest.movies.data;

import org.example.javatest.movies.model.Genre;
import org.example.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = {id};
        // Devuelve solo un objeto
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        // Devuelve una lista de elementos.
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        Object[] args = {movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector()};
        jdbcTemplate.update("insert into movies (name, minutes,genre,director) values(?,?,?,?)", args);

    }

    private static final RowMapper<Movie> movieMapper = (resultSet, i) ->
            new Movie(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("minutes"),
                    Genre.valueOf(resultSet.getString("genre")),
                    resultSet.getString("director")
            );
}
