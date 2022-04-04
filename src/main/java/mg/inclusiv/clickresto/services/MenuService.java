package mg.inclusiv.clickresto.services;

import mg.inclusiv.clickresto.entity.Menu;
import mg.inclusiv.clickresto.entity.Restaurant;

import java.util.List;

public interface MenuService {
    Menu saveMenu(Menu menu);
    List<Menu> findAllByRestaurant(Restaurant restaurant);
    Menu findByNom(String nom);
    List<Menu> findAll();
}
