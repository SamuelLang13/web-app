package server.api.dto.movie;

import server.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

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
    private Set<String> genres = new HashSet<>();
}
