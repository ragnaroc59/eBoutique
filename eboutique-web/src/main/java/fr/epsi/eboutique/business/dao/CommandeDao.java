package fr.epsi.eboutique.business.dao;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.entity.CommandeLigne;
import fr.epsi.eboutique.business.entity.Produit;
import fr.epsi.eboutique.business.service.ProduitService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Named
public class CommandeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ProduitService produitService;

    public Collection<Commande> findAll(){

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object[]> commandeFromBase = entityManager.createNativeQuery(
                "SELECT * FROM commande").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        factory = Persistence
                .createEntityManagerFactory("eboutique-business");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object[]> commandeLignes = entityManager.createNativeQuery(
                "SELECT * FROM comm_produit").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if (commandeFromBase == null) {
            System.out.println("Pas de marque trouvée ! ");
        }

        Collection<Commande> commandeList = new ArrayList<>();
        Collection<CommandeLigne> comm_ligne = new ArrayList<>();


        for (Object[] comL: commandeLignes)
        {
            CommandeLigne commandeLigne = new CommandeLigne();
            commandeLigne.setCommandeId(Long.parseLong(comL[0].toString()));
            commandeLigne.setProduit(produitService.findProduitById(Long.parseLong(comL[1].toString())));
            commandeLigne.setQuantite(Integer.parseInt(comL[2].toString()));
            comm_ligne.add(commandeLigne);
        }

        for (Object[] com: commandeFromBase)
        {
            Commande commande = new Commande();
            commande.setIdentifier(Long.parseLong(com[0].toString()));
            String date =com[1].toString().substring(0,10);
            commande.setDateCreation(LocalDate.parse(date));
            commande.setLignes(getLignes(comm_ligne,commande.getIdentifier()));
            commandeList.add(commande);
        }

        return commandeList;
    }

    private Collection<CommandeLigne> getLignes(Collection<CommandeLigne> comm_ligne,Long commandeId){
        Collection<CommandeLigne> lignesToReturn = new ArrayList<>();
        for(CommandeLigne ligne : comm_ligne){
            if(commandeId.equals(ligne.getCommandeId())){
                lignesToReturn.add(ligne);
            }
        }
        return lignesToReturn;
    }
}
