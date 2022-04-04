package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    private Integer  quantite;


    @Column(nullable = false)
    private double montant;

    @Column(nullable = false,updatable = false,insertable = false)
    private Long commandeId;

    @Column(nullable = false,updatable = false,insertable = false)
    private Long menuId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "commandeId")
    private Commande commande;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "menuId")
    private Menu menu;



}
