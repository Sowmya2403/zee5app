package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.repo.MovieRepo;
import com.zee.zee5app.repo.MovieRepoImpl;
import com.zee.zee5app.repo.UserRepoImpl;

public class MovieServiceImpl implements MovieService {
	
	private MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
//	MovieRepo movieRepo2 = 
	
	private static MovieServiceImpl movieServiceImpl;
	
	public static MovieServiceImpl getInstance() {
		// userRepo object
		
		if(movieServiceImpl == null) {
			movieServiceImpl = new MovieServiceImpl();
			
		}
		
		return movieServiceImpl;
	}
	
	private MovieRepo movieRepo = MovieRepoImpl.getInstance();

	@Override
	public Optional<Movie> insertMovie(Movie movie) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		return null;
		//trailer file exists or not
		//shift that file to zee5app/trailer folder
		//provide the location to trailer field
		//then take the path and store it in db. ----> handled by repo
		File file = new File(movie.getTrailer1());
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		System.out.println(file.getName());
		try {
			if(movie.getTrailer1() == null 
					|| movie.getTrailer1() == ""
					||!file.exists()){
				throw new FileNotFoundException("file does not exists");
			}
			
			else {
				
				bufferedInputStream = 
						new BufferedInputStream(new FileInputStream(file));
				
				bufferedOutputStream = new BufferedOutputStream(
						new FileOutputStream("D:\\tr\\"+ file.getName() ));
				bufferedOutputStream.write(bufferedInputStream.readAllBytes());
				
				System.out.println("file exists");
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return movieRepo.insertMovie(movie);

	}
	
	

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
	
		return movieRepo.updateMovie(movieId, movie);
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.getMovieByMovieId(movieId);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepo.getAllMovies();
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByGenre(Genre genre) {
		// TODO Auto-generated method stub
		return movieRepo.getAllMoviesByGenre(genre);
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return movieRepo.getAllMoviesByName(movieName);
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.deleteMovieByMovieId(movieId);
	}

}
