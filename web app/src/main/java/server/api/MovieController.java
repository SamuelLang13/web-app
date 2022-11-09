package server.api;

import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Collection<MovieDTO> getAllMovies(){
        return MovieConverter.fromModels(movieService.readAll());
    }

    @GetMapping("/get/{id}")
    public MovieDTO getMovie(@PathVariable Long id){
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        return MovieConverter.fromModel(movieService.getById(id).get());
    }

    @PostMapping
    public String createMovie(@ModelAttribute("movieInDto")  MovieInDto movieDTO) throws Exception {
        movieService.create(MovieConverter.toModel(movieDTO));
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) throws Exception {
        movieService.delete(id);
        return "redirect:/";
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody MovieInDto movieInDto) {
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        movieService.update(id,movieInDto);
    }


}
