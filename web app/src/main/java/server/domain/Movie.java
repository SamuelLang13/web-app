package server.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Movie {

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
}
