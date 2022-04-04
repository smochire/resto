package mg.inclusiv.clickresto.repository;


import mg.inclusiv.clickresto.entity.Menu;
import mg.inclusiv.clickresto.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findAllByRestaurant(Restaurant restaurant);
    Menu findByNom(String nom);
}
