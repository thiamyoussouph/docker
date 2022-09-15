package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypesJobDeMaintenance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typesJobDeMaintenance")
    private Collection<Jobs> jobs;
}