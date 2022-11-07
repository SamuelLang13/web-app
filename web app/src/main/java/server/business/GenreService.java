package server.business;

import server.dao.GenreRepository;
import server.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService extends AbstractCrudService<Long, Genre, GenreRepository>{

    private GenreRepository genreRepository;

    @Override
    public boolean exists(Genre entity) {
        return false;
    }

    public GenreService(GenreRepository repository) {
        super(repository);
    }

    public Genre findGenre(String name){
        Optional<Genre> genre = genreRepository.getGenreByName(name);
        return genre.orElse(null);
    }



}
