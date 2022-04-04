package mg.inclusiv.clickresto.controller;

import mg.inclusiv.clickresto.entity.Categorie;
import mg.inclusiv.clickresto.entity.Menu;
import mg.inclusiv.clickresto.entity.Restaurant;
import mg.inclusiv.clickresto.services.CategorieService;
import mg.inclusiv.clickresto.services.MenuService;
import mg.inclusiv.clickresto.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@Transactional
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private RestaurantService restaurantService;
    @PostMapping("produit/insert")
    public String   insert (@RequestParam("email") String email ,@ModelAttribute("menu") Menu menu, @RequestParam("img") MultipartFile multipartFile, @RequestParam("cat") String nomCat)
    {
        Restaurant  resto = restaurantService.getByEmail(email);
        Categorie categorie = categorieService.getByNom(nomCat);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.contains("..")) { System.out.println("Image non valide");}
        try { menu.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes())); }
        catch (IOException e) { e.printStackTrace(); }

        if(categorie==null)
        {
            Categorie cat = new Categorie();
            cat.setNom(nomCat);
            Categorie categorie1= categorieService.saveCategorie(cat);
            menu.setCategorie(categorie1);
        }else{
            menu.setCategorie(categorie);
        }
        menu.setRestaurant(resto);

        menuService.saveMenu(menu);

        return "redirect:/restaurant/produits";
    }
}
