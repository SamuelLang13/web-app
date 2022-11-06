package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieID;
    private String movieName;
    private int length;
    private int year;
    private String externalLink;
    @OneToMany
    @JoinColumn
    private Set<Genre> genres = new HashSet<>();

}
