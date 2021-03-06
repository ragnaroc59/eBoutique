package fr.epsi.eboutique.web.controller.site;

import fr.epsi.eboutique.business.service.MarqueService;
import fr.epsi.eboutique.business.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class AccueilController {

  @Inject
  private MarqueService marqueService;

  @Inject
  private ProduitService produitService;

  /**
   * Permet d'afficher la page d'accueil
   * 
   * @param critere Critere de reccherche
   * @return
   */
  @GetMapping("/accueil")
  public ModelAndView displayAccueil(@RequestParam(required = false) String critere) {
    if(critere==null){
        ModelAndView mv = new ModelAndView("public/accueil");
        mv.addObject("marques", this.marqueService.findAll());
        mv.addObject("allProducts",this.produitService.findAll());
        return mv;
    }else{
        ModelAndView mv = new ModelAndView("public/accueil");
        mv.addObject("marques", this.marqueService.findAll());
        mv.addObject("allProducts", this.produitService.findByResearch(critere));
        return mv;
    }
  }

  @GetMapping("/accueil/{marque}")
  public ModelAndView displayMarque(@PathVariable String marque) {
    ModelAndView mv = new ModelAndView("public/accueil/marque");
    mv.addObject("products", this.produitService.findProduitByMarque(marque));
    
    //TODO Recuperer les 10 premiers produits correspondant à la marque recherché
    
    //TODO Recuperer le nombre total de produits correspondant à la marque recherché 
    //afin de permettre la pagination
    
    return mv;
  }
  
}
