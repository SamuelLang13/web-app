package server.api;

import org.springframework.web.bind.annotation.*;
import server.api.dto.genre.GenreConverter;
import server.api.dto.genre.GenreDTO;
import server.api.dto.genre.GenreInDto;
import server.api.dto.movie.MovieConverter;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.api.exception.NoEntityFoundException;
import server.business.GenreService;
import lombok.AllArgsConstructor;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/genre")
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping
    public Collection<GenreDTO> getAllGenres(){
        return GenreConverter.fromModels(genreService.readAll());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable Long id) {
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        return GenreConverter.fromModel(genreService.getById(id).get());
    }

    @PostMapping
    public void createGenre(@RequestBody GenreInDto genreDTO) throws Exception {
        genreService.create(GenreConverter.toModel(genreDTO));
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody GenreInDto movieInDto) {
        if(!genreService.findById(id)){
            throw new NoEntityFoundException();
        }
        genreService.update(id,movieInDto);
    }


}
