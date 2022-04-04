package mg.inclusiv.clickresto.services;

import mg.inclusiv.clickresto.entity.Commande;


import java.util.List;


public interface CommandeService {
   List<Commande> findByAllRestaurantId(Long restaurantId);
   Commande saveCommande (Commande commande);
}
