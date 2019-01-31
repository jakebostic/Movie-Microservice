package microservice.workshop.moviecastservice.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import microservice.workshop.moviecastservice.data.CastMemberRepository;
import microservice.workshop.moviecastservice.model.CastMember;

/*
 * TODO (Exercise 2) - Make this a proper rest controller.
 * 
 * The controller should respond to a URL like "/cast/search?movieId=x" where x is a movie id.
 * The controller should always return a list of cast members - an empty list is a valid response if
 * there are no cast members for the given ID.
 */

@RestController
@RequestMapping("/cast")
public class CastController {
	
	@Autowired CastMemberRepository castRepository;
	
	@GetMapping(path="/search")
	public @ResponseBody List<CastMember> getCastMembers(@RequestParam int movieId) {
		return castRepository.findByMovieId(movieId);
	}
}
