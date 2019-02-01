package microservice.workshop.movieservice.http;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import microservice.workshop.movieservice.data.MovieRepository;
import microservice.workshop.movieservice.model.Movie;

/*
 * TODO (Exercise 2) - Make this a proper rest controller.
 * 
 * The controller should respond to a URL like "/movie/x" where x is a movie id.
 * If the movie exists, return the movie and status OK (200).
 * If the movie does not exist, return a status of NOT_FOUND (404)
 */
@RestController
public class MovieController {
	
	@Autowired MovieRepository movieRepository;
	
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Optional<Movie> getMovie(@PathVariable int id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if (!movie.isPresent()) {
			throw new MovieNotFoundException("id-" + id);
			}
		return movieRepository.findById(id);
		}
}

