package fr.epsi.eboutique.business.dao;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.entity.CommandeLigne;
import fr.epsi.eboutique.business.service.ProduitService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        List<Object[]> commandeFromBase = this.entityManager.createNativeQuery(
                "SELECT * FROM commande").getResultList();


        List<Object[]> commandeLignes = this.entityManager.createNativeQuery(
                "SELECT * FROM comm_produit").getResultList();

        if (commandeFromBase == null) {
            System.out.println("Pas de commande trouvée ! ");
        }
        Collection<Commande> commandeList = new ArrayList<>();
        Collection<CommandeLigne> comm_ligne = new ArrayList<>();

        for (Object[] comL: commandeLignes)
        {
            CommandeLigne commandeLigne = new CommandeLigne();
            commandeLigne.setCommandeId(Long.parseLong(comL[0].toString()));
            commandeLigne.setProduit(this.produitService.findProduitById(Long.parseLong(comL[1].toString())));
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

    public boolean createCommande(Commande command) {
        this.entityManager.createQuery("insert into commande values(:id,:dateCreation)")
                .setParameter("id",command.getIdentifier())
                .setParameter("dateCreation",command.getDateCreation());
        for (CommandeLigne ligne: command.getLignes()){
            this.entityManager.createQuery("insert into comm_produit values(:id,:produitId,:quantite)")
                    .setParameter("id",command.getIdentifier())
                    .setParameter("produitId",ligne.getProduit().getIdentifier())
                    .setParameter("quantite",ligne.getQuantite());
        }
        return true;
    }

    public Commande getCommandeById(Long commandId){
        List<Object[]> commandeFromBase = this.entityManager.createNativeQuery(
                "SELECT * FROM commande where id=:commandeId").setParameter("commandeId",commandId).getResultList();


        List<Object[]> commandeLignes = this.entityManager.createNativeQuery(
                "SELECT * FROM comm_produit where commande_id=:commandeId").setParameter("commandeId",commandId).getResultList();

        if (commandeFromBase == null) {
            System.out.println("Pas de commande trouvée ! ");
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

        return ((ArrayList<Commande>) commandeList).get(0);
    }
}
