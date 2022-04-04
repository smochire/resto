package mg.inclusiv.clickresto.services.impl;

import mg.inclusiv.clickresto.entity.Commande;
import mg.inclusiv.clickresto.repository.CommandeRepository;
import mg.inclusiv.clickresto.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<Commande> findByAllRestaurantId(Long restaurantId) {
        return commandeRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
}
