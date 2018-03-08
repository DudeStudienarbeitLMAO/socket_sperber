package info.sperber;

import info.sperber.jpa.entities.Hairdresser;
import info.sperber.jpa.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by fabian on 3/8/18.
 */
public class Hibernate {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emf");
        EntityManager manager = factory.createEntityManager();

        Person p = new Person();
        p.setFirstName("Lalf");
        p.setLastName("Rausen");

        Hairdresser hd = new Hairdresser();
        hd.setName("Sudoko Lover Extreme");

        p.setFavouriteHairdresser(hd);

        manager.getTransaction().begin();
        manager.persist(p);
        manager.persist(hd);
        manager.getTransaction().commit();
    }
}
