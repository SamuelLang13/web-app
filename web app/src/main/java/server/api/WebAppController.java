package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.api.exception.NoEntityFoundException;
import server.business.MovieService;
import server.domain.Movie;

import java.util.Collection;

@Controller
public class WebAppController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", movieService.readAll());
        return"index";
    }

    @GetMapping("/add-movie")
    public String addNewMovie(Model model) {
        MovieInDto movieInDto = new MovieInDto();
        model.addAttribute("movie", movieInDto);
        return "addmovie";
    }

    @GetMapping("/update-movie/{id}")
    public String updateMovie(@PathVariable long id, Model model) {
        MovieInDto movie = new MovieInDto();
        model.addAttribute("movie", movie);
        return "updatemovie";
    }

    @GetMapping("/get-movie/{id}")
    public String getMovie(@PathVariable Long id, Model model){
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        model.addAttribute("movie",movieService.getById(id).get());
        return "movie";
    }

    @GetMapping("/delete-movie/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        movieService.delete(id);
        return "redirect:/";
    }

}
