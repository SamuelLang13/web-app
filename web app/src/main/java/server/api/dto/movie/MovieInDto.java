package server.api.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInDto {
    private String movieName;
    private int length;
    private int year;
    private String externalLink;
}
