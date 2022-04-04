package mg.inclusiv.clickresto.services.impl;

import mg.inclusiv.clickresto.entity.Categorie;
import mg.inclusiv.clickresto.repository.CategorieRepository;
import mg.inclusiv.clickresto.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository repository;

    public CategorieServiceImpl(CategorieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return repository.save(categorie);
    }

    @Override
    public Categorie getByNom(String nom) {
        return repository.getByNom(nom);
    }
}
