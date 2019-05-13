package fr.epsi.eboutique.web.controller.site;

import fr.epsi.eboutique.business.service.CommandeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Controleur permettant de gérer le panier du client.
 * 
 * @author nrousseau1
 *
 */
@Controller
public class PanierController {

    @Inject
    private CommandeService commandeService;

    @GetMapping("/commande")
    public ModelAndView displayPanel() {
        ModelAndView mv = new ModelAndView("public/command/command");
        mv.addObject("commands", this.commandeService.findAll());

        //TODO Recuperer les 10 premiers produits correspondant à la marque recherché

        //TODO Recuperer le nombre total de produits correspondant à la marque recherché
        //afin de permettre la pagination

        return mv;
    }
}
