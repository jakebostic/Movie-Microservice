package microservice.workshop.movieaggregatorservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import microservice.workshop.movieaggregatorservice.model.Movie;


/*
 * TODO (Exercise 3) - create Feign clients for the three individual services, then
 * use the Feign clients in this service to compose a complete object. Call the movie-service first.
 * If the movie service returns a value, then call the cast and award services to compose the full
 * movie object.
 */
public class AggregateMovieService {
	
	@Autowired MovieService movieService;
	@Autowired MovieCastService castService;
	@Autowired MovieAwardService awardService;
    
    public Optional<Movie> findById(@PathVariable Integer movieId) {
        Optional<Movie> movie = movieService.findMovieById(movieId);
        if (movie.isPresent()) {
        	castService.getCastMembers(movieId);
        	awardService.findAwardsForMovie(movieId);
        }
    	
    	return Optional.empty();
    }
}
