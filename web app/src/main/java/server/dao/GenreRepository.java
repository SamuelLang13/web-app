package server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import server.domain.Genre;
import server.domain.GenreType;
import server.domain.Movie;

import java.util.Optional;
import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    public Optional<Genre> getGenreByName(String name);

}
