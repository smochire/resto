package mg.inclusiv.clickresto.services;


import mg.inclusiv.clickresto.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant  restaurant);
    Restaurant getByEmail(String email);
    Restaurant getById(Long id);
    Restaurant updateRestaurant(Restaurant restaurant, Long id);
    Restaurant updatePasswordRestaurant(String  password, Restaurant restaurant);
    List<Restaurant> findAll();
}
