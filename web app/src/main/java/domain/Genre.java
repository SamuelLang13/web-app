package domain;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreID;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn
    private Movie movie;
}
