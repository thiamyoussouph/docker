package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Modele {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libellet;

    @ManyToOne

    private Marque marque;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "modele")
    private Collection<Vehicules>vehicules;
    @ManyToOne
    private TypesVehicules typesVehicules;
}
