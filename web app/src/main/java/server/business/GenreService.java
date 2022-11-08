package server.business;

import server.dao.GenreRepository;
import server.domain.Genre;
import org.springframework.stereotype.Service;
import server.domain.Movie;

import java.util.Optional;

@Service
public class GenreService extends AbstractCrudService<Long, Genre, GenreRepository>{

    private GenreRepository genreRepository;

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

    public GenreService(GenreRepository repository) {
        super(repository);
    }

}
