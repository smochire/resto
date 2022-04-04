package mg.inclusiv.clickresto.repository;

import java.util.List;
import mg.inclusiv.clickresto.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande>  findAllByRestaurantId(Long restaurantId);
}

