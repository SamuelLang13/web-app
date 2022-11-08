package server.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreID;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn
    private Movie movie;


    public String getMovieName(){
        if(movie==null){
            return  null;
        }
        return movie.getMovieName();
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", name='" + name + '\'' +
                ", movie=" + movie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreID, genre.genreID) && name.equals(genre.name) && Objects.equals(movie, genre.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreID, name, movie);
    }
}
