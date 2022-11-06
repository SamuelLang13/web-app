package domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

}
