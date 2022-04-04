package mg.inclusiv.clickresto.repository;


import mg.inclusiv.clickresto.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant getByEmail(String  email);
}
