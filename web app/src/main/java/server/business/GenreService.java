package server.business;

import server.api.dto.genre.GenreInDto;
import server.api.dto.genreMovie.GenreMovie;
import server.api.dto.movie.MovieInDto;
import server.api.exception.NoEntityFoundException;
import server.dao.GenreRepository;
import server.domain.Genre;
import org.springframework.stereotype.Service;
import server.domain.Movie;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GenreService extends AbstractCrudService<Long, Genre, GenreRepository>{

    private GenreRepository genreRepository;

    public GenreService(GenreRepository repository) {
        super(repository);
    }

    @Override
    public boolean exists(Genre genre) {
        Optional<Genre> optionalGenre = repository.getGenreByName(genre.getName());
        return optionalGenre.isPresent();
    }

    @Override
    public boolean findById(Long key) {
        return repository.findById(key).isPresent();
    }

    @Override
    public Optional<Genre> getById(Long key) {
        return repository.findById(key);
    }

    @Transactional
    public void update(Long key, Genre genreInDto){
        Genre genre = getEntityById(key);
        genre.setName(genreInDto.getName());
    }

    public Genre getByName(String genreName){
        Optional<Genre> genre = repository.getGenreByName(genreName);
        if(genre.isEmpty()){
            throw new NoEntityFoundException();
        }
        return genre.get();
    }


}
