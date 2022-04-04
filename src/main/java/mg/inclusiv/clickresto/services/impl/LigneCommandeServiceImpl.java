package mg.inclusiv.clickresto.services.impl;

import mg.inclusiv.clickresto.entity.Commande;
import mg.inclusiv.clickresto.entity.LigneCommande;
import mg.inclusiv.clickresto.repository.LigneCommandeRepository;
import mg.inclusiv.clickresto.services.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LigneCommandeServiceImpl implements LigneCommandeService {
    @Autowired
    private LigneCommandeRepository  ligneCommandeRepository;
    @Override
    public List<LigneCommande> getByCommandeId(Long commandeId) {
        return  ligneCommandeRepository.getByCommandeId(commandeId);
    }

    @Override
    public List<LigneCommande> findAll() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public List<LigneCommande> listeLigne(Commande commande) {
        return ligneCommandeRepository.findAllByCommande(commande);
    }

    @Override
    public LigneCommande saveLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }


}
