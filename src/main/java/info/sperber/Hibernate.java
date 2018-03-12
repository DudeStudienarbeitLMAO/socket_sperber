package info.sperber;

import info.sperber.jpa.entities.Hairdresser;
import info.sperber.jpa.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

import static org.hibernate.ejb.QueryImpl.LOG;

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

    private static void printDatabase(EntityManagerFactory emf) throws SQLException {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Person> query = manager.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> list = query.getResultList();
        for (Person table : list) {
            LOG.info(table.toString());
        }
        LOG.info("-----------------------");
        manager.getTransaction().commit();
    }
}
