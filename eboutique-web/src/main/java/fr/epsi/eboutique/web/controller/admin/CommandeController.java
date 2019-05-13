package fr.epsi.eboutique.web.controller.admin;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.service.CommandeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class CommandeController {

    @Inject
    private CommandeService commandeService;

    @GetMapping("/admin/commande")
    public ModelAndView createCommand(Commande command) {
        ModelAndView mv = new ModelAndView("public/command/command");
        mv.addObject("isCommandCreated", this.commandeService.createCommande(command));
        return mv;
    }

    @GetMapping("/admin/commande/{idCommand}")
    public ModelAndView getCommandeById(@PathVariable(name = "idCommand") Long idCommand) {
        ModelAndView mv = new ModelAndView("public/command/command");
        mv.addObject("commandFound", this.commandeService.getCommandeById(idCommand));
        return mv;
    }
}
