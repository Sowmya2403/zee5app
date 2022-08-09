package com.zee.zee5app.repo;

//import java.lang.StackWalker.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.utils.DBUtils;

public class MovieRepoImpl implements MovieRepo {
	
	DBUtils dbUtils = DBUtils.getInstance();
	
	private MovieRepoImpl() {
        // TODO Auto-generated constructor stub
    }
	
//	private List<Movie> movies = new ArrayList<>();
	
	
    private static MovieRepo movieRepo;
    
    public static MovieRepo getInstance() {
        // userRepo object
        
    	
    	
        if(movieRepo == null) {
        	movieRepo = new MovieRepoImpl();
            
        }
        
        return movieRepo;
    }
	
    
    
 
    
    
    

	@Override
	public Optional<Movie> insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStm = "insert into movie_table(movieid, actors,"
				+ " moviename, director, genre,"
				+ " production,\r\n"
				+ "	languages, movielength,trailer1) values(?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStm);
			preparedStatement.setString(1, movie.getMovieId());
			preparedStatement.setString(2, String.join(",", movie.getActors()));
			preparedStatement.setString(3, movie.getMovieName());
			preparedStatement.setString(4, movie.getDirector());
			preparedStatement.setString(5, movie.getGenre().toString());
			preparedStatement.setString(6, movie.getProduction());
			preparedStatement.setString(7, String.join(",",movie.getLanguages()));
			preparedStatement.setFloat(8, movie.getMovieLength());
			preparedStatement.setString(9, movie.getTrailer1());
			int result = preparedStatement.executeUpdate();
			if(result>0) {
//				System.out.println("sdbhsdbcjsajn"); 
				return Optional.of(movie);
			}else {
				return Optional.empty();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
		
		
		
		
		
		return Optional.empty();
//		return null;
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		Optional<Movie> movie2 = this.getMovieByMovieId(movieId);
//		
//		if(movie2.isPresent()) {
//			if(movies.remove(movie2.get())) {
//				movies.add(movie);
//				return Optional.of(movie);
//			}else {
//				throw new NoDataFoundException("NO Movie found");
//			}
//			
//		}
		
		this.deleteMovieByMovieId(movieId);
		return this.insertMovie(movie);
		
		
		
//		return null;
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String retreivalst = "select * from movie_table where movieid=?";
		ResultSet resultSet = null;
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(retreivalst);
			preparedStatement.setString(1, movieId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieId(resultSet.getString("movieid"));
				movie.setDirector(resultSet.getString("director"));
				movie.setMovieLength(resultSet.getFloat("movielenght"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setProduction(resultSet.getString("production"));
				movie.setActors(resultSet.getString("actors").split(","));
				movie.setLanguages(resultSet.getString("langauges").split(","));
				movie.setGenre(Genre.valueOf(resultSet.getString("genre")));
				movie.setTrailer1(resultSet.getString("trailer1"));
				return Optional.of(movie);
			}else {
				return Optional.empty();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
		
		
	}

	@Override
	public Optional<List<Movie>> getAllMovies() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "select * from movie_table";
//		preparedStatement = dbUtils.getConnection();
		connection = dbUtils.getConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieId(resultSet.getString("movieid"));
				movie.setDirector(resultSet.getString("director"));
				movie.setMovieLength(resultSet.getFloat("movielenght"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setProduction(resultSet.getString("production"));
				movie.setActors(resultSet.getString("actors").split(","));
				movie.setLanguages(resultSet.getString("langauges").split(","));
				movie.setGenre(Genre.valueOf(resultSet.getString("genre")));
				movie.setTrailer1(resultSet.getString("trailer1"));
				movies.add(movie);
			}
			return Optional.of(movies);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByGenre(Genre genre) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "select * from movie_table where genre=?";
//		preparedStatement = dbUtils.getConnection();
		connection = dbUtils.getConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(5, genre.toString());
			resultSet = preparedStatement.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieId(resultSet.getString("movieid"));
				movie.setDirector(resultSet.getString("director"));
				movie.setMovieLength(resultSet.getFloat("movielenght"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setProduction(resultSet.getString("production"));
				movie.setActors(resultSet.getString("actors").split(","));
				movie.setLanguages(resultSet.getString("langauges").split(","));
				movie.setGenre(Genre.valueOf(resultSet.getString("genre")));
				movie.setTrailer1(resultSet.getString("trailer1"));
				movies.add(movie);
			}
			return Optional.of(movies);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "select * from movie_table where moviename=?";
//		preparedStatement = dbUtils.getConnection();
		connection = dbUtils.getConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(3, movieName);
			resultSet = preparedStatement.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieId(resultSet.getString("movieid"));
				movie.setDirector(resultSet.getString("director"));
				movie.setMovieLength(resultSet.getFloat("movielenght"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setProduction(resultSet.getString("production"));
				movie.setActors(resultSet.getString("actors").split(","));
				movie.setLanguages(resultSet.getString("langauges").split(","));
				movie.setGenre(Genre.valueOf(resultSet.getString("genre")));
				movie.setTrailer1(resultSet.getString("trailer1"));
				movies.add(movie);
			}
			return Optional.of(movies);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		Optional<Movie> optional = this.getMovieByMovieId(movieId);
//		if(optional.isPresent()) {
//			if(!movies.remove(optional.get())) {
//				throw new NoDataFoundException("No movie found");
//			}else {
//				return "Success";
//			}
//		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "delete from movie_table where movieid=?";
//		preparedStatement = dbUtils.getConnection();
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, movieId);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return "success";
			} else {
				throw new NoDataFoundException("Movie id is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
//			System.out.println();
		}

		return "fail";

//		return null;
	}

	

	@Override
	public List<Movie> FindByOrderByMovieNameDsc() {
		
//		List<Movie> movies2 = new ArrayList<>(movies);
//		
//		
////		method1
//		
//		Comparator<Movie> comparator =(e1,e2)->{
//			return e2.getMovieName().compareTo(e1.getMovieName());
//		};
//		
//		Collections.sort(movies2, comparator);
//		
////		method2
////		Collections.sort(movies2, (e1,e2)->
////			e2.getMovieName().compareTo(e1.getMovieName()));
//		
//		// TODO Auto-generated method stub
//		return movies2;
		return null;
	}

}
