package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.inclusiv.clickresto.entity.Commande;
import mg.inclusiv.clickresto.entity.Reservation;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false ,length = 45)
    private String  nom;

    @Column(nullable = false,length = 45, insertable = false, updatable = false)
    private Long restaurantId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column(nullable = false)
    private String creat_at =  new Date().toString();

}
