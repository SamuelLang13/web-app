package server.api.dto.genre;

import server.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenreDTO {
    private Long genreID;
    private String name;
    private String movieName;
}
