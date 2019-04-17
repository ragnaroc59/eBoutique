package fr.epsi.eboutique.business.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.epsi.eboutique.business.entity.Marque;

@Named
public class MarqueDao {
  
  /**
   * Permet de récupérer l'entity manager via le CDI 
   */
  @PersistenceContext
  private EntityManager entityManager;
  

  public Collection<Marque> findAll(){

    EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("eboutique-business");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    List<Marque> marqueList = entityManager.createQuery(
            "SELECT q FROM Marque q").getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();

    if (marqueList == null) {
      System.out.println("Pas de marque trouvée ! ");
    } else {
      for (Marque marque : marqueList) {
        System.out.print(" - Marque :" +marque.getLibelle() + " nombre de produit de cette marque : " + marque.getProduits().size());
      }
    }

    return marqueList;
  }

  public Marque findByLibelle(String libelle){

    EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("eboutique-business");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    List<Marque> marqueList = entityManager.createQuery(
            "SELECT q FROM Marque q WHERE libelle LIKE :custName").setParameter("custName",libelle).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();

    if (marqueList == null) {
      System.out.println("Pas de marque trouvée ! ");
    }
    return marqueList.get(0);
  }
}
