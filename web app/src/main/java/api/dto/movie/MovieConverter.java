package api.dto.movie;

import api.dto.genre.GenreConverter;
import api.dto.genre.GenreDTO;
import domain.Genre;
import domain.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieConverter {
    public static MovieDTO fromModel(Movie movie){
        return new MovieDTO(movie.getMovieID(), movie.getMovieName(), movie.getLength(), movie.getYear(), movie.getExternalLink(), movie.getGenres());
    }

    public static Movie  toModel(MovieDTO movieDTO){
        return new Movie(movieDTO.getMovieName(), movieDTO.getLength(), movieDTO.getYear(), movieDTO.getExternalLink());
    }

    public static Collection<Movie> toModels(Collection<MovieDTO> movies){
        return movies.stream().map(MovieConverter::toModel).collect(Collectors.toList());
    }

    public static Collection<MovieDTO>  fromModels(Collection<Movie> movies){
        return movies.stream().map(MovieConverter::fromModel).collect(Collectors.toList());
    }
}
