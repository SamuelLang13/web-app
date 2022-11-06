package api.dto;

import domain.Genre;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GenreConverter {

    public static GenreDTO  fromModel(Genre genre){
        return new GenreDTO(genre.getGenreID(), genre.getName(), genre.getMovie());
    }

    public static Genre  toModel(GenreDTO genre){
        return new Genre(genre.getName());
    }

    public static Collection<Genre>  toModels(Collection<GenreDTO> genres){
        return genres.stream().map(GenreConverter::toModel).collect(Collectors.toList());
    }

    public static Collection<GenreDTO>  fromModels(Collection<Genre> genres){
        return genres.stream().map(GenreConverter::fromModel).collect(Collectors.toList());
    }
}
