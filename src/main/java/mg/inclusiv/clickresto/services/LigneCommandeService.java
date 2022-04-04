package mg.inclusiv.clickresto.services;



import mg.inclusiv.clickresto.entity.Commande;
import mg.inclusiv.clickresto.entity.LigneCommande;

import java.util.List;

public interface LigneCommandeService {
    List<LigneCommande> getByCommandeId(Long commandeId);
    List<LigneCommande> findAll();
    List<LigneCommande> listeLigne(Commande commande);
    LigneCommande saveLigneCommande (LigneCommande ligneCommande);
}
