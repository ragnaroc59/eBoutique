package fr.epsi.eboutique.business.dao;

import fr.epsi.eboutique.business.entity.Produit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Named
public class ProduitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MarqueDao marqueDao;


    public Collection<Produit> findAll(){

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Produit> produitList = entityManager.createQuery(
                "SELECT q FROM Produit q").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        return produitList;
    }

    public Collection<Produit> findProduitByMarque(String marque){

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Produit> produitList = entityManager.createQuery(
                "SELECT q FROM Produit q WHERE marque_id  LIKE :marqueId").setParameter("marqueId",marqueDao.findByLibelle(marque).getIdentifier()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        return produitList;
    }
}
