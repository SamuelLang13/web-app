package server.api;

import org.springframework.web.bind.annotation.*;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.business.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

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

    //        return AwardConverter.fromModel(awardService.create(AwardConverter.toModel(awardDTO)));
    @PostMapping
    public void saveMovie(@RequestBody MovieDTO movieDTO) throws Exception {
        movieService.create(MovieConverter.toModel(movieDTO));
    }


}
