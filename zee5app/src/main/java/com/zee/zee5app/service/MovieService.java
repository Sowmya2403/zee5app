package com.zee.zee5app.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.NoDataFoundException;

public interface MovieService {
	public Optional<Movie> insertMovie(Movie movie) throws FileNotFoundException;
    public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException;

    public Optional<Movie> getMovieByMovieId(String movieId);
    public Optional<List<Movie>> getAllMovies();
    public Optional<List<Movie>> getAllMoviesByGenre(Genre genre);
    public Optional<List<Movie>> getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId) throws NoDataFoundException;

}
