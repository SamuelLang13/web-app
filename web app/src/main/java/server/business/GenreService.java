package server.business;

import server.dao.GenreRepository;
import server.domain.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractCrudService{

    private GenreRepository genreRepository;

}
