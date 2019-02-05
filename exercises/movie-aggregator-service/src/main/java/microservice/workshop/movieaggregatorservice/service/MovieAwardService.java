package microservice.workshop.movieaggregatorservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import microservice.workshop.movieaggregatorservice.model.MovieAward;

/* TODO 
 Enable this interface to be a Feign client for the existing movie award web service with the following characteristics:
- use the name movie-award-service for the Feign client.
- use the URL http://localhost:8083
- write a method that will return a List<MovieAward> for a given movie id
*/

@FeignClient(name="movie-award-service", url="http://localhost:8083")
public interface MovieAwardService {
	
	@GetMapping("/award/search")
	List<MovieAward> findAwardsForMovie(@RequestParam("movieId") Integer movieId);
}
