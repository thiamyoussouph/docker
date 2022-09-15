package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class KilometrageVehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long kilometrage;
    private Date dateEnregistrement;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    Vehicules vehicules;
}
