package domain;

import javax.persistence.*;

@Table
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreID;
    private String name;
}
