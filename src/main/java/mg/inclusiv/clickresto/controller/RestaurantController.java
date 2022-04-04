package mg.inclusiv.clickresto.controller;

import mg.inclusiv.clickresto.donnee.Consulter;
import mg.inclusiv.clickresto.entity.*;
import mg.inclusiv.clickresto.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private CommandeService commandeService;

    private Restaurant resto;

    public Restaurant getResto() {
        return resto;
    }

    public void setResto(Restaurant resto) {
        this.resto = resto;
    }

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private MenuService menuService;
    @Autowired
    private LigneCommandeService ligneCommandeService;



    @RequestMapping("/register")
    public String register(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurants",restaurantService.findAll());
        return "account-register-page";
    }

    @PostMapping("/demande")
    public String demande(@ModelAttribute Restaurant restaurant, @RequestParam("image") MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("Image non valide");
        }
        try {
            restaurant.setLogo(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        restaurant.setPassword(restaurant.getEmail());
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurant/password";
    }

    @RequestMapping("/demande")
    public String partenaire() {
        return "partenaire-demande-success";
    }

    @RequestMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("restaurants",restaurantService.findAll());
        return "login";
    }

    @PostMapping("/profile")
    public String profile(@RequestParam("email") String email, @RequestParam("password") String password) {
        String sortie = "";
        this.resto = restaurantService.getByEmail(email);

        if (resto == null || !resto.getPassword().equals(password)) {
            sortie = "redirect:/restaurant/login";
        } else {

            sortie = "redirect:/restaurant/profile";
        }

        return sortie;
    }

    @RequestMapping("/profile")
    public String dashboard(Model model) {
        if (resto == null) {
            return "redirect:/restaurant/login";
        } else {
            model.addAttribute("restaurant", resto);
            model.addAttribute("restaurants",restaurantService.findAll());
            return "restaurant-owner-profile";
        }

    }

    @RequestMapping("/ajout")
    public String ajout(Model model) {
        Menu menu = new Menu();
        if (resto == null) {
            return "redirect:/restaurant/login";
        } else {
            model.addAttribute("menu", menu);
            model.addAttribute("restaurant", resto);
            return "restaurant-ajout-produit";
        }

    }

    @RequestMapping("/detail")
    public String detail(Model model) {
        if (resto == null) {
            return "redirect:/restaurant/login";
        } else {
            model.addAttribute("restaurant", resto);
            model.addAttribute("restaurants",restaurantService.findAll());
            return "restaurant-detail";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Restaurant restaurant, @RequestParam("image") MultipartFile multipartFile) {
        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("Image non valide");
            }
            try {
                restaurant.setLogo(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            restaurant.setLogo(resto.getLogo());
        }
        restaurantService.updateRestaurant(restaurant, resto.getId());
        return profile(resto.getEmail(), resto.getPassword());
    }

    @RequestMapping("/password")
    public String forgotPassword(Model model)
    {
        model.addAttribute("restaurants",restaurantService.findAll());
        return "account-forgot-password-page";
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestParam("password") String password, @RequestParam("email") String email) {
        Restaurant restaurant = restaurantService.getByEmail(email);
        if (restaurant == null) {
            return "redirect:/restaurant/register";
        } else {
            restaurantService.updatePasswordRestaurant(password, restaurant);
            return "redirect:/restaurant/login";
        }
    }


    @RequestMapping("/produits")
    public String listeProduit(Model model) {
        if (resto == null) {
            return "redirect:/restaurant/login";
        } else {
            model.addAttribute("restaurant", resto);
            List<Menu> menus = menuService.findAllByRestaurant(resto);
            model.addAttribute("menus", menus);
            return "restaurant-consulter-produit";
        }
    }

    @RequestMapping("/commandes")
    public String listeLigneCommande(Model model) {
        if (resto == null) {
            return "redirect:/restaurant/login";
        } else {
            List<Consulter> consulters = new ArrayList<>();
            List<Commande> commandes = commandeService.findByAllRestaurantId(resto.getId());
            model.addAttribute("restaurant", resto);
            for (Commande commande : commandes) {
                List<LigneCommande> ligneCommandes = ligneCommandeService.listeLigne(commande);
                int i = 1;
                for (LigneCommande ligneCommande : ligneCommandes) {
                    Consulter consulter = new Consulter();
                    consulter.setQuantite(ligneCommande.getQuantite());
                    consulter.setEtat(ligneCommande.getCommande().getEtat());
                    consulter.setPrix(ligneCommande.getMenu().getPrix());
                    consulter.setNomMenu(ligneCommande.getMenu().getNom());
                    consulter.setOrdre(i);
                    consulters.add(consulter);
                    i++;
                }
            }
            model.addAttribute("consulters", consulters);
            model.addAttribute("restaurants", restaurantService.findAll());
            return "restaurant-consulter-commande";
        }
    }



    @RequestMapping("/success")
    public String paiement(Model model)
    {
        model.addAttribute("restaurants",restaurantService.findAll());
        return "order-success";
    }

}
