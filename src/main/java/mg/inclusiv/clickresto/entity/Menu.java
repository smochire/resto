package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nom;


    @Column(nullable = false)
    private Float prix;

    @Lob
    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private boolean isAvalaible=true;

    @Column(nullable = false,  columnDefinition = "text")
    private String description;

    @Column(nullable = false,updatable = false,insertable = false)
    private Long restaurantId;

    @Column(nullable = false,updatable = false,insertable = false)
    private Long categorieId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurantId")
    private Restaurant  restaurant;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categorieId")
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "menu")
    private List<LigneCommande> ligneCommandes = new ArrayList<>();

   

}
