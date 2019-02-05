package microservice.workshop.movieaggregatorservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import microservice.workshop.movieaggregatorservice.model.CastMember;

@FeignClient(name="movie-cast-service", url="http://localhost:8082")
public interface MovieCastService {
	
	List<CastMember> getCastMembers(@RequestParam("movieId") Integer movieId);

}
