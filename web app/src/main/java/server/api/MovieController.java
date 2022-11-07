package server.api;

import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.business.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Collection<MovieDTO> getAllMovies(){
        return MovieConverter.fromModels(movieService.readAll());
    }


}
