package server.api.dto.genre;

import server.domain.Genre;

import java.util.Collection;
import java.util.stream.Collectors;

public class GenreConverter {

    public static GenreDTO  fromModel(Genre genre){
        return new GenreDTO(genre.getGenreID(), genre.getName(), genre.getMovieName());
    }

    public static Genre  toModel(GenreInDto genre){
        return new Genre(genre.getGenreName());
    }

    public static Collection<Genre>  toModels(Collection<GenreInDto> genres){
        return genres.stream().map(GenreConverter::toModel).collect(Collectors.toList());
    }

    public static Collection<GenreDTO>  fromModels(Collection<Genre> genres){
        return genres.stream().map(GenreConverter::fromModel).collect(Collectors.toList());
    }
}
