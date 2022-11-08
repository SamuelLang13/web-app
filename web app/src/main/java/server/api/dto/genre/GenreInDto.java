package server.api.dto.genre;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class GenreInDto {
    private String genreName;

    @JsonCreator
    public GenreInDto(String genreName){
        this.genreName = genreName;
    }
}
