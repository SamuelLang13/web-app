package api.dto;

import domain.Genre;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GenreConverter {

    public static GenreDTO  fromModel(Genre genre){
        return new GenreDTO(genre.getGenreID(), genre.getName(), genre.getMovie());
    }

    public static Collection<GenreDTO>  fromModels(Collection<Genre> genres){
        return genres.stream().map(GenreConverter::fromModel).collect(Collectors.toList());
    }
}
