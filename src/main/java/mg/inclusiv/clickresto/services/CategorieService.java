package mg.inclusiv.clickresto.services;

import mg.inclusiv.clickresto.entity.Categorie;

public interface CategorieService {
    Categorie saveCategorie(Categorie  categorie);
    Categorie getByNom(String  nom);
}
