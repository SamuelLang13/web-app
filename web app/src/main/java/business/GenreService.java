package business;

import dao.GenreRepository;
import domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService extends AbstractCrudService{

    private GenreRepository genreRepository;

}
