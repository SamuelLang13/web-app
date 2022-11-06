package api.dto;

import domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenreDTO {
    private Long genreID;
    private String name;
    private Movie movie;
}
