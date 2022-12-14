package server.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieID;
    @NonNull
    private String movieName;
    @NonNull
    private int length;
    @NonNull
    private int year;
    @NonNull
    private String externalLink;
    @OneToMany
    @JoinColumn
    private Set<Genre> genres = new HashSet<>();


    public Set<String> getGenreName(){
        return genres.stream().map(Genre::getName).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", length=" + length +
                ", year=" + year +
                ", externalLink='" + externalLink + '\'' +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return length == movie.length && year == movie.year && Objects.equals(movieID, movie.movieID) && movieName.equals(movie.movieName) && externalLink.equals(movie.externalLink) && Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieID, movieName, length, year, externalLink, genres);
    }
}
