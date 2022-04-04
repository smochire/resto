package mg.inclusiv.clickresto.controller;




import mg.inclusiv.clickresto.entity.Restaurant;
import mg.inclusiv.clickresto.services.MenuService;
import mg.inclusiv.clickresto.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Transactional
public class AccueilController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    MenuService menuService;
    /**
     * Page d'accueil 
     * @param model
     * @return index.html
     */
    @GetMapping("/")
    public String acceuil (Model model)
    {
        model.addAttribute("menu", menuService.findAll());
        model.addAttribute("cuisines",restaurantService.findAll());
        return "index";
    }
     
    /**
     * Affiche la page d'accueil d'un client (Manque l'idresto et l'idclient)
     * @param model
     * @return menu-1.html
     */
    @GetMapping("/accueil/client/{id}")
    public String acceuilClient (Model model,@PathVariable("id") String id)
    {
        Long idResto = Long.parseLong(id);
        Restaurant restaurant = restaurantService.getById(idResto);
        model.addAttribute("menu", menuService.findAllByRestaurant(restaurant));

        model.addAttribute("resturant",restaurant);
        model.addAttribute("restaurants",restaurantService.findAll());
        return "menu-1";
    }


    @RequestMapping("/accueil/how")
    public String how()
    {
        return "how-it-work";
    }

    @RequestMapping("/accueil/cuisines")
    public String cuisine()
    {
        return "all-cuisines";
    }

    @RequestMapping("/accueil/apropos")
    public String apropos(Model model)
    {
        model.addAttribute("restaurants",restaurantService.findAll());
        return "about-us";
    }

    @RequestMapping("/accueil/policy")
    public String policy(Model model)
    {
        model.addAttribute("restaurants",restaurantService.findAll());
        return "privacy-policy";
    }
    @RequestMapping("/accueil/contact")
    public String contact(Model model)
    {
        model.addAttribute("restaurants", restaurantService.findAll());
        return "contact";
    }
   
}
