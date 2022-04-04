package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Entity
public class Commande {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String creatAt =  new Date().toString();


    @Column(nullable = false)
    private String etat="En attente";

    @Column(nullable = false)
    private double montant;


    @Column(nullable = true,updatable = false,insertable = false)
    private Long restaurantId;



    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "commande")
    private List<LigneCommande> ligneCommandes =  new ArrayList<>();

    
}
