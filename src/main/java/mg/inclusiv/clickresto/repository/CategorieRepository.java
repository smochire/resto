package mg.inclusiv.clickresto.repository;

import mg.inclusiv.clickresto.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie getByNom(String nom);
}
