package mg.inclusiv.clickresto.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String creatAt =  new Date().toString();


    @Column(nullable = false)
    private String dateresa;

    @Column(nullable = false,length = 2)
    private Integer place;

    @Column(nullable = false, updatable = false, insertable = false)
    private Long restaurantId;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;



}
