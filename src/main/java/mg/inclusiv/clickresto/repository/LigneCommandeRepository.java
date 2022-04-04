/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.inclusiv.clickresto.repository;

import java.util.List;
import mg.inclusiv.clickresto.entity.Commande;
import mg.inclusiv.clickresto.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin Inclusiv 2
 */
@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
    
    @Query("Select c from LigneCommande c where c.commandeId=?1")
    List<LigneCommande> findByCommandeId(Long commandeId);
    List<LigneCommande> getByCommandeId(Long commandeId);
    List<LigneCommande> findAllByCommande(Commande commande);

}
