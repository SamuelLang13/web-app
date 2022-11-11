package server.api.dto.genreMovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreMovie {

    private String movieName;
    private String genreName;
}
