package api;

import api.dto.GenreConverter;
import api.dto.GenreDTO;
import business.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/genre")
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping
    public Collection<GenreDTO> getAllGenres(){
        return GenreConverter.fromModels(genreService.readAll());
    }


}
