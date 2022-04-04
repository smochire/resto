package mg.inclusiv.clickresto.services.impl;

import mg.inclusiv.clickresto.entity.Menu;
import mg.inclusiv.clickresto.entity.Restaurant;
import mg.inclusiv.clickresto.repository.MenuRepository;
import mg.inclusiv.clickresto.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository  repository;

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public List<Menu> findAllByRestaurant(Restaurant restaurant) {
        return repository.findAllByRestaurant(restaurant);
    }

    @Override
    public Menu findByNom(String nom) {
        return repository.findByNom(nom);
    }

    @Override
    public List<Menu> findAll() {
        return repository.findAll();
    }


}
