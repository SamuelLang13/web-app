package api.dto.movie;

import domain.Genre;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
public class MovieDTO {
    private Long movieID;
    private String movieName;
    private int length;
    private int year;
    private String externalLink;
    private Set<Genre> genres = new HashSet<>();
}
