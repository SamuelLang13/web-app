package domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieID;
    private String movieName;
    private int length;
    private int year;
    private String externalLink;

}
