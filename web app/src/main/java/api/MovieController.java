package api;

import api.dto.movie.MovieDTO;
import business.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @GetMapping
    public Collection<MovieDTO> getAllMovies(){
        return null;
    }
}
