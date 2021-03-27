package monPaquet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;


//  On fera en sorte que cette classe soit un singleton

public class Bu  extends Observable implements IBu {
    //  Les elements provenant de la base de donnees  ou bien du websockets seront stockes ici
    // Ensuite cette classe se chargera de notifier les Vues

    public final List<Livre> livres  = new ArrayList<Livre>() ;

    public static EntityManager entityManager;
    public Bu() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override

    public void save(Livre livre) {
        entityManager.getTransaction().begin();
        entityManager.persist(livre);
        entityManager.getTransaction().commit();

    }


    @Override
    public void save(Auteur auteur) {
        entityManager.getTransaction().begin();
        entityManager.persist(auteur);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Livre> findAll() {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("SELECTION DEPUIS LIVRES");
        //livres.add( new Livre("MY BOOK", "ROMAN", "DAVID") );
        entityManager.getTransaction().commit();
        setChanged();
        notifyObservers();
        Iterator<Livre> iterator = (q.getResultList()).iterator();
        while (iterator.hasNext()) {
            livres.add(iterator.next());
        }
        return q.getResultList();
    }


    @Override
    public List<Livre> findByCategorie(String mc) {
        entityManager.getTransaction().begin();
        Query q =entityManager.createQuery("SELECT LORSQUE s.Categorie EST :x");
        q.setParameter("x" , "%"+mc+"%");
        entityManager.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public void update(Livre livre) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Livre findById(UUID uuid) {
        entityManager.getTransaction().begin();
        entityManager.find(Livre.class ,uuid );
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public void init() {
        entityManager.getTransaction().begin();
        entityManager.persist(new Livre("s longue lettre", "Baa" ,"art"));
        entityManager.persist(new Livre("matrix", "Bernad" ,"Film"));
        System.out.println("ok parti");

        entityManager.getTransaction().commit();

    }
}

