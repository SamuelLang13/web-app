package server.dao;

import server.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Optional<Movie> getMovieByMovieNameAndAndYearAndExternalLink(String name, int year, String externalLink);
    public Optional<Movie> getMovieByMovieName(String name);

    public Optional<Movie> getMovieByMovieID(Long id);
}
