package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false,length = 120 , unique = true)
    private String  nom;

    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "categorie")
    private List<Menu> menus =  new ArrayList<>();

}
