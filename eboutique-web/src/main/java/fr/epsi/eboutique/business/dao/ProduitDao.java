package fr.epsi.eboutique.business.dao;

import fr.epsi.eboutique.business.entity.Produit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Named
public class ProduitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MarqueDao marqueDao;


    public Collection<Produit> findAll(){
        return this.entityManager.createQuery("from Produit p").getResultList();

        /*EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object[]> produitList = entityManager.createNativeQuery(
                "SELECT * FROM Produit").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        Collection<Produit> productToReturn = new ArrayList<>();
        for(Object[] product : produitList)
        {
            Produit produit = new Produit();
            produit.setLibelle(product[1].toString());
            produit.setIdentifier(Long.parseLong(product[0].toString()));
            produit.setImage(product[5].toString());
            produit.setMarque(marqueDao.findById(Long.parseLong(product[4].toString())));
            produit.setDescription(product[2].toString());
            produit.setPrix(BigDecimal.valueOf(Double.parseDouble(product[3].toString()))); //prix
            productToReturn.add(produit);
        }

        return productToReturn;*/
    }

    public Collection<Produit> findProduitByMarque(String marque){
        return this.entityManager.createQuery("from Produit p where p.marque=:marque").setParameter("marque", marqueDao.findByLibelle(marque)).getResultList();
        /*

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object[]> produitList = entityManager.createNativeQuery(
                "SELECT * FROM Produit WHERE marque_id  = :marqueId").setParameter("marqueId",marqueDao.findByLibelle(marque).getIdentifier()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        Collection<Produit> products = new ArrayList<>();

        for (Object[] ma: produitList) {
            Produit produit = new Produit();
            produit.setIdentifier(Long.parseLong(ma[0].toString())); //id
            produit.setLibelle(ma[1].toString()); //libelle
            produit.setDescription(ma[2].toString()); //description
            produit.setPrix(BigDecimal.valueOf(Double.parseDouble(ma[3].toString()))); //prix
            produit.setMarque(marqueDao.findById(Long.parseLong(ma[4].toString()))); //marque_id
            produit.setImage(ma[5].toString()); // image
            products.add(produit);
        }

        return products;*/
    }

    public Produit findProduitById(Long productId){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object[]> produitList = entityManager.createNativeQuery(
                "SELECT * FROM Produit WHERE id  = :productId").setParameter("productId",productId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        Produit produit = new Produit();

        for (Object[] ma: produitList) {
            produit.setIdentifier(Long.parseLong(ma[0].toString())); //id
            produit.setLibelle(ma[1].toString()); //libelle
            produit.setDescription(ma[2].toString()); //description
            produit.setPrix(BigDecimal.valueOf(Double.parseDouble(ma[3].toString()))); //prix
            produit.setMarque(marqueDao.findById(Long.parseLong(ma[4].toString()))); //marque_id
            produit.setImage(ma[5].toString()); // image
            break;
        }

        return produit;
    }

    public Collection<Produit> findByResearch(String word){
       return this.entityManager.createQuery("from Produit p where p.libelle like :libelle").setParameter("libelle", "%"+word+"%").getResultList();
/*        List<Object[]> produitList = entityManager.createNativeQuery(
                "SELECT * FROM Produit WHERE libelle LIKE '%':searchWord'%'").setParameter("searchWord",word).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (produitList == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        Collection<Produit> productToReturn = new ArrayList<>();
        for(Object[] product : produitList)
        {
            Produit produit = new Produit();
            produit.setLibelle(product[1].toString());
            produit.setIdentifier(Long.parseLong(product[0].toString()));
            produit.setImage(product[5].toString());
            produit.setMarque(marqueDao.findById(Long.parseLong(product[4].toString())));
            produit.setDescription(product[2].toString());
            produit.setPrix(BigDecimal.valueOf(Double.parseDouble(product[3].toString()))); //prix
            productToReturn.add(produit);
        }

        return productToReturn;*/
    }
}
