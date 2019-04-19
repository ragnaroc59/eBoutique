package fr.epsi.eboutique.business.service;

import fr.epsi.eboutique.business.dao.ProduitDao;
import fr.epsi.eboutique.business.entity.Produit;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
public class ProduitService {

    @Inject
    ProduitDao produitDao;

    public Collection<Produit> findProduitByMarque(String marque){
        return produitDao.findProduitByMarque(marque);
    }

    public Collection<Produit> findAll(){
        return produitDao.findAll();
    }

    public Produit findProduitById(Long productId){return produitDao.findProduitById(productId);}
}
