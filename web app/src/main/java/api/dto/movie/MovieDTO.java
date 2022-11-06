package api.dto.movie;

import domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class MovieDTO {
    private Long movieID;
    private String movieName;
    private int length;
    private int year;
    private String externalLink;
    private Set<Genre> genres = new HashSet<>();
}
