package info.sperber.jpa.entities;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by fabian on 3/8/18.
 */
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Hairdresser favouriteHairdresser;
}
