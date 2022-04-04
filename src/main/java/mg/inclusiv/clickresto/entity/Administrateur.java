package mg.inclusiv.clickresto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)

    private String nom;

    @Column(nullable = false, length = 45)
    private String prenom;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private String creatAt = new SimpleDateFormat("dd MMMM yyyy ' ' hh:mm:ss").format(new Date());
}
