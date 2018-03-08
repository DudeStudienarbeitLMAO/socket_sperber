package info.sperber.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabian on 3/8/18.
 */
@Entity
@Data
public class Hairdresser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "favouriteHairdresser")
    private List<Person> customers = new ArrayList<Person>();
}
