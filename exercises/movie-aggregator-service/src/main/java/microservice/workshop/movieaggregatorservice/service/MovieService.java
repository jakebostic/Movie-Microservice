package microservice.workshop.movieaggregatorservice.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import microservice.workshop.movieaggregatorservice.model.Movie;

@FeignClient(name="movie-service", url="http://localhost:8081")
public interface MovieService {
	
	@GetMapping("/movie/{id}")
	Optional<Movie> findMovieById(@RequestParam("movieId") Integer movieId);

}
