package mg.inclusiv.clickresto.donnee;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulter {
    private Integer ordre;
    private String nomMenu;
    private Integer quantite;
    private Float prix;
    private String etat;
    private String nomClient;


}
