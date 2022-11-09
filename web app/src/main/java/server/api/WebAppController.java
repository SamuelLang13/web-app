package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.business.MovieService;

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

    @GetMapping("/add-new-movie")
    public String addNewMovie(Model model) {
        MovieInDto movieInDto = new MovieInDto();
        model.addAttribute("movie", movieInDto);
        return "newmovie";
    }

}
