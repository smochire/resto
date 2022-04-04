package mg.inclusiv.clickresto.services.impl;


import mg.inclusiv.clickresto.entity.Restaurant;
import mg.inclusiv.clickresto.repository.RestaurantRepository;
import mg.inclusiv.clickresto.services.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Restaurant getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Restaurant getById(Long id) {

        return repository.getById(id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
        Restaurant restaurant1 = repository.getById(id);
        restaurant1.setLogo(restaurant.getLogo());
        restaurant1.setAdresse(restaurant.getAdresse());
        restaurant1.setNom(restaurant.getNom());
        restaurant1.setNomResto(restaurant.getNomResto());
        restaurant1.setEmail(restaurant.getEmail());
        restaurant1.setTelephone(restaurant.getTelephone());
        restaurant1.setTypeCuisine(restaurant.getTypeCuisine());
        restaurant1.setMessage(restaurant.getMessage());
        repository.save(restaurant1);
        return restaurant1;
    }

    @Override
    public Restaurant updatePasswordRestaurant(String password,Restaurant restaurant) {
        restaurant.setPassword(password);
        repository.save(restaurant);
        return restaurant;
    }

    @Override
    public List<Restaurant> findAll() {
        return repository.findAll();
    }


}
