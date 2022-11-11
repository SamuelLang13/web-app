package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import server.api.dto.genre.GenreInDto;
import server.api.dto.genreMovie.GenreMovie;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.api.exception.IllegalAction;
import server.api.exception.NoEntityFoundException;
import server.business.GenreService;
import server.business.MovieService;
import server.domain.Genre;
import server.domain.GenreType;
import server.domain.Movie;

import javax.swing.text.html.Option;
import java.util.*;

@Controller
public class WebAppController {

    @Autowired
    MovieService movieService;

    @Autowired
    GenreService genreService;

    /**
     * Main page
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", movieService.readAll());
        model.addAttribute("genres", genreService.readAll());
        return"index";
    }

    /**
     * Redirect to add-movie page
     * @param model
     * @return
     */
    @GetMapping("/add-movie")
    public String addNewMovie(Model model) {
        MovieInDto movieInDto = new MovieInDto();
        model.addAttribute("movieIn", movieInDto);
        return "addmovie";
    }

    /**
     * Redirect to add-genre page
     * @param model
     * @return
     */
    @GetMapping("/add-genre")
    public String addNewGenre(Model model) {
        GenreInDto genreInDto = new GenreInDto();
        model.addAttribute("genreIn", genreInDto);
        return "addgenre";
    }

    @GetMapping("/update-movie/{id}")
    public String updateMovie(@PathVariable long id, Model model) {
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        Movie movie = movieService.getEntityById(id);
        model.addAttribute("updateMovie", movie);
        return "updatemovie";
    }

    @PostMapping("/save-movie")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.update(movie.getMovieID(),movie);
        return "redirect:/";
    }

    @PostMapping("/save-genre")
    public String saveMovie(@ModelAttribute("genre") Genre genre) {
        genreService.update(genre.getGenreID(),genre);
        return "redirect:/";
    }

    @GetMapping("/update-genre/{id}")
    public String updateGenre(@PathVariable long id, Model model) {
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        Genre genre = genreService.getEntityById(id);
        model.addAttribute("updateGenre", genre);
        return "updategenre";
    }

    /**
     * Get movie by id at standalone page
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/get-movie/{id}")
    public String getMovie(@PathVariable Long id, Model model){
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        model.addAttribute("movie",movieService.getById(id).get());
        return "movie";
    }

    @GetMapping("/get-genre/{id}")
    public String getGenre(@PathVariable Long id, Model model){
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        model.addAttribute("genre",genreService.getById(id).get());
        return "genre";
    }

    /**
     * Delete movie by id
     * @param id
     * @return
     */
    @GetMapping("/delete-movie/{id}")
    public String deleteMovieById(@PathVariable(value = "id") long id) {
        if(!movieService.findById(id)){
            throw new NoEntityFoundException();
        }
        Movie movie = movieService.getEntityById(id);
        if(movie.getGenres()!=null){
            throw new IllegalAction();
        }
        movieService.delete(id);
        return "redirect:/";
    }

    /**
     * Delete genre by id
     * @param id
     * @return
     */
    @GetMapping("/delete-genre/{id}")
    public String deleteGenreById(@PathVariable(value = "id") long id) {
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        Genre genre = genreService.getEntityById(id);
        if(genre.getMovieName()!=null){
            throw new IllegalAction();
        }
        genreService.delete(id);
        return "redirect:/";
    }

    @PutMapping("/save")
    public void updateMovie(@PathVariable Long id, @ModelAttribute("updateGenre") Genre genre) {
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        genreService.update(id,genre);
    }

    @GetMapping("/add-genre-to-movie")
    public String addGenreToMovie(Model model){
        GenreMovie genreMovie = new GenreMovie();
        model.addAttribute("genreMovie", genreMovie);
        return "addgenretomovie";
    }


    @PostMapping("/save")
    public String saveGenreMovie(@ModelAttribute("employee") GenreMovie genreMovie) {
        Genre genre = genreService.getByName(genreMovie.getGenreName());
        Movie movie = movieService.getByName(genreMovie.getMovieName());
        Set<Genre> genreSet = movie.getGenres();
        genreSet.add(genre);
        genre.setMovie(movie);
        return "redirect:/";
    }

}
