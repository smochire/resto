package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false ,length = 45)
    private String  nom;


    @Column(nullable = false,length = 60)
    private String nomResto;

    
    @Column(nullable = false,length = 65)
    private String typeCuisine;

    @Lob
    @Column(nullable = false)
    public String logo;

    @Column(nullable = false,  length = 60,unique = true)
    private String  email;

    @Column(nullable = false,unique = true)
    private String  telephone;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private String  adresse;

    @Column(nullable = false)
    private boolean isValidated = false;
    

    @Column(columnDefinition =  "text")
    private String message;

    @Column(nullable = false)
    private String creatAt =  new Date().toString();

    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "restaurant")
    private List<Commande>  commandes =  new ArrayList<>();

     @OneToMany(cascade = CascadeType.MERGE,mappedBy = "restaurant")
     private List<Menu>  menus =  new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "restaurant")
    private List<Reservation>  reservations =  new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "restaurant")
    private List<Client> clients = new ArrayList<>();
}
