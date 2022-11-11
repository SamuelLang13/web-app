package server.business;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.api.dto.genreMovie.GenreMovie;
import server.api.dto.movie.MovieDTO;
import server.api.dto.movie.MovieInDto;
import server.api.exception.NoEntityFoundException;
import server.dao.GenreRepository;
import server.dao.MovieRepository;
import server.domain.Genre;
import server.domain.Movie;

import javax.transaction.Transactional;
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
        return repository.findById(key).isPresent();
    }

    @Override
    public Optional<Movie> getById(Long key) {
        return repository.findById(key);
    }

    @Transactional
    public void update(Long key, MovieInDto movieDTO){
        Movie movie = getEntityById(key);
        movie.setMovieName(movieDTO.getMovieName());
        movie.setYear(movieDTO.getYear());
        movie.setLength(movieDTO.getLength());
        movie.setExternalLink(movieDTO.getExternalLink());
    }

    @Transactional
    public void update(Long key, Movie movieDTO){
        Movie movie = getEntityById(key);
        movie.setMovieName(movieDTO.getMovieName());
        movie.setYear(movieDTO.getYear());
        movie.setLength(movieDTO.getLength());
        movie.setExternalLink(movieDTO.getExternalLink());
    }

    public void doesHaveGenre(){

    }

    public void addGenre(GenreMovie genreMovie){

    }


    public Movie getByName(String movieName) {
        Optional<Movie> movie = repository.getMovieByMovieName(movieName);
        if(movie.isEmpty()){
            throw new NoEntityFoundException();
        }
        return movie.get();
    }
}
