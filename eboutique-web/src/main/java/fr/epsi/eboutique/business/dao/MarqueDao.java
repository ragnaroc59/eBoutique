package fr.epsi.eboutique.business.dao;

import java.util.ArrayList;
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

    return this.entityManager.createQuery("from Marque m").getResultList();

    /*EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("eboutique-business");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    List<Object[]> marqueFromBase = entityManager.createNativeQuery(
            "SELECT * FROM Marque").getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();


    if (marqueFromBase == null) {
      System.out.println("Pas de marque trouvée ! ");
    }

    Collection<Marque> marqueList = new ArrayList<>();

    for (Object[] ma: marqueFromBase)
    {
      Marque marque = new Marque();
      marque.setIdentifier(Long.parseLong(ma[0].toString()));
      marque.setLibelle(ma[1].toString());
      marqueList.add(marque);
    }

    return marqueList;*/
  }

  public Marque findByLibelle(String libelle){

    EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("eboutique-business");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    List<Object[]> marqueList = entityManager.createNativeQuery(
            "SELECT * FROM Marque m WHERE libelle = :lbl").setParameter("lbl",libelle).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();
    Marque marque = new Marque();

    if (marqueList == null) {
      System.out.println("Pas de marque trouvée ! ");
    }else{
      for (Object[] ma: marqueList) {
        Long id = Long.parseLong(ma[0].toString());
        marque.setIdentifier(id);
        break;
      }
    }

    return marque;
  }

  public Marque findById(Long marqueId){
    EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("eboutique-business");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    List<Object[]> marqueList = entityManager.createNativeQuery(
            "SELECT * FROM Marque m WHERE id = :marqueId").setParameter("marqueId",marqueId).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();
    Marque marque = new Marque();

    if (marqueList == null) {
      System.out.println("Pas de marque trouvée ! ");
    }else{
      for (Object[] ma: marqueList) {
        Long id = Long.parseLong(ma[0].toString());
        marque.setLibelle(ma[1].toString());
        marque.setIdentifier(id);
        break;
      }
    }

    return marque;
  }
}
