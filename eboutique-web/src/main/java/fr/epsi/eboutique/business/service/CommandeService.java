package fr.epsi.eboutique.business.service;

import fr.epsi.eboutique.business.dao.CommandeDao;
import fr.epsi.eboutique.business.entity.Commande;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
public class CommandeService {

    @Inject
    private CommandeDao commandeDao;

    public Collection<Commande> findAll() {
        return this.commandeDao.findAll();
    }

    public boolean createCommande(Commande command) {
        return this.commandeDao.createCommande(command);
    }

    public Object getCommandeById(Long idCommand) {
        return this.commandeDao.getCommandeById(idCommand);
    }
}
