package server.api.dto.movie;

import server.domain.Genre;
import server.domain.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieConverter {
    public static MovieDTO fromModel(Movie movie){
        return new MovieDTO(movie.getMovieID(), movie.getMovieName(), movie.getLength(), movie.getYear(), movie.getExternalLink(), movie.getGenreName());
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
