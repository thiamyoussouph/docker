package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Date dateDebut;
    private  Date dateFin;
    @ManyToOne
    private Vehicules vehicules;
    @ManyToOne
    private Chauffeur chauffeur;
}
