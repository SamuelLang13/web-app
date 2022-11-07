package server.business;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.GenreRepository;
import server.dao.MovieRepository;
import server.domain.Genre;
import server.domain.Movie;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService extends AbstractCrudService<Long, Movie, MovieRepository> {

    @Autowired
    public MovieService(MovieRepository movieRepository){
        super(movieRepository);
    }

    @Override
    public boolean exists(Movie movie) {
        Optional<Movie> optionalMovie = repository.getMovieByMovieNameAndAndYearAndExternalLink(movie.getMovieName(),movie.getYear(), movie.getExternalLink());
        return optionalMovie.isPresent();
    }

    @Override
    public boolean findById(Long key) {
        Optional<Movie> optionalMovie = repository.getMovieByMovieID(key);
        return optionalMovie.isPresent();
    }


}
