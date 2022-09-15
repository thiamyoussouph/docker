package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sn.kai.kaivoiture.enums.TypesCarburant;
import sn.kai.kaivoiture.enums.VehiculeSatus;
import sn.kai.kaivoiture.enums.vehiculeEtats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicules {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String Numerochassie;
    @Column(name = "Matricule",unique = true,length = 33)
    private String Matricule;
    private int NombrePlace;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSOrtie;
    private Date DateMisEnMarche;
    private Date DateAchat;
    private String TypesCarburant;
    @Enumerated(EnumType.STRING)
    private VehiculeSatus status;
    @Enumerated(EnumType.STRING)
    private vehiculeEtats Etats;
    private boolean etatpanne;
    private boolean enmarche;
    @ManyToOne
    private Modele modele;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "vehicules")
    private Collection<PannesVehicule> pannesVehicules;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "vehicules")
    private Collection<Affectation>affectations;
    @OneToMany(mappedBy = "vehicules")
    private Collection<KilometrageVehicule>kilometrageVehicules;
    @OneToMany(mappedBy = "vehicules")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Event>events;
}
