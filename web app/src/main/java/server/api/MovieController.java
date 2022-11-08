package server.api;

import org.springframework.web.bind.annotation.*;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.api.exception.NoEntityFoundException;
import server.business.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import server.domain.Movie;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Collection<MovieDTO> getAllMovies(){
        return MovieConverter.fromModels(movieService.readAll());
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable Long id){
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        return MovieConverter.fromModel(movieService.getById(id).get());
    }

    @PostMapping
    public void createMovie(@RequestBody MovieInDto movieDTO) throws Exception {
        movieService.create(MovieConverter.toModel(movieDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) throws Exception {
        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody MovieInDto movieInDto) {
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        movieService.update(id,movieInDto);
    }


}
