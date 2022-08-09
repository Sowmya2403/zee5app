package com.zee.zee5app;

import java.io.FileNotFoundException;
//import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.MovieServiceImpl;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;
import com.zee.zee5app.utils.IdComparator;

//import com.zee.zee5app.dto.User;

public class Main {
	public static void main(String[] args) {
		
		
		
//		System.out.println("jnJub");
//		UserService userService = UserServiceImpl.getInstance();
//		try {
//			userService.insertUser(
//					new User("abhi","chivate","kuldeepi",LocalDate.now(),LocalDate.of(1988, 12, 9)));
//		} catch (UNableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		System.out.println(userService.getUserById("ab1117676767671").get());
		
		
//		String movieId, String[] actors, String movieName, String director, String[] genre, String production,
//		String[] languages, float movieLength
		String[] actors = {"a","b","c"};
//		String[] genre = {"ag","bg","cg"};
		String[] lan = {"al","bl","cl"};
		
		MovieService movieService = MovieServiceImpl.getInstance();
		
		
		
		
		try {
			movieService.insertMovie(new Movie("rr105",actors ,"rrr","director",Genre.FICTION,
					"production",lan,(float) 2.0,"D:\\zee5app\\CruelSummer.mp4" ));
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////		
 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Movie> movies1 = movieService.getAllMovies().get();
//		for (Movie movie : movies1) {
//			System.out.println(movie);
//		}
//		
//		
////		
//		try {
//			movieService.updateMovie("rr105", new Movie("rr105",actors ,"rrr","director",Genre.DRAMA,
//					"production",lan,(float) 2.0,"trailer1" ));
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoDataFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		System.out.println(movieService.getMovieByMovieId("rr102").get());
//		List<Movie> movies = movieService.getAllMovies().get();
//		for (Movie movie : movies) {
//			System.out.println(movie);
//		}
//		
//		
//		
//		try {
//			System.out.println(movieService.deleteMovieByMovieId("rr103"));
//		} catch (NoDataFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
		
		
		
		
		
//		User user = new User();
//		Collections.sort(User, IdComparator);
		
		
//		Optional<User> result = userService.getUserById("ab001");
//		
//		if(result.isPresent()) {
//			System.out.println("no record found");
//		}else {
//			User user = result.get();
//			System.out.println(user);
//		}

		
		
//		System.out.println("Hello Kuldeep");
//		User user = new User();
//		User user =  new User();
//		System.out.println(user);
//		System.out.println(user.toString());
//		System.out.println(user.getClass().getName());
//		System.out.println(user.hashCode());
//		System.out.println(Integer.toHexString(user.hashCode()));
		
//		UserServiceImpl userservice = UserServiceImpl.getInstance();
//		
//		User user  = new User();
//		
////		switch case
//		final int operation = 1;
//		
//		switch (operation) {
//		case 1:
//			String result = userservice.insertUser(user);
//			if("success".equals(result)) {
//				System.out.println("user is added successfully");
//			}else {
//				System.out.println("user not found");
//			}
//			
//			break;
//		case 2:
//			User[] users = userservice.getallusers();
//			
//			if(users==null) {
//				System.out.println("no record found");
//			}else {
//				for (User user1 : users) {
//					if(user1!=null) {
//						System.out.println(user1);
//					}
//				}
//			}
//			
//		case 3:
//			User specificuser = userservice.getuserbyid(user.getUserId());
//			if(specificuser==null) {
//				System.out.println("no user found for this id");
//			}else {
//				System.out.println(specificuser);
//			}
//			
//			break;
//			
//		case 4:
//			
//			String result1 = userservice.deleteuserbyid(user.getUserId());
//			if("success".equals(result1)) {
//				System.out.println("user is added successfully");
//			}else {
//				System.out.println("user not found");
//			}
//			
//			break;
//			
//			
//			
//		default:
//			break;
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
		

		
		
		
		
		
		
		
//		delete(id)
//		update(id,new obj)
		
	}

}



//mysql workbench
//postman

//vscode
//oracle vm
//nodejs
//mongo db
//android studio