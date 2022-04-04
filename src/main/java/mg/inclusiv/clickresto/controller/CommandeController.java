package mg.inclusiv.clickresto.controller;

import mg.inclusiv.clickresto.entity.*;
import mg.inclusiv.clickresto.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class CommandeController {
    @Autowired
    MenuService menuService;
    @Autowired
    private CommandeService commandeService;



    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @PostMapping("/commande/paiement")
    private String affichePanier(@RequestParam("nom") String[] nom, @RequestParam("quantite") String[] quantite, @RequestParam("prix") String[] prix, @RequestParam("montant2") String montant, @RequestParam("resto") String email) {
        Commande commande = new Commande();
        commande.setMontant(Double.parseDouble(montant));
        Restaurant restaurant = restaurantService.getByEmail(email);
        commande.setRestaurant(restaurant);
        Commande commande1 = commandeService.saveCommande(commande);
        for (int i = 0; i < nom.length; i++) {
            LigneCommande ligneCommande = new LigneCommande();
            Menu menu = menuService.findByNom(nom[i]);
            ligneCommande.setCommande(commande1);
            ligneCommande.setMenu(menu);
            ligneCommande.setMontant(Double.parseDouble(prix[i]));
            ligneCommande.setQuantite(Integer.parseInt(quantite[i]));
            ligneCommandeService.saveLigneCommande(ligneCommande);
        }


        return "redirect:/restaurant/success";
    }
}
