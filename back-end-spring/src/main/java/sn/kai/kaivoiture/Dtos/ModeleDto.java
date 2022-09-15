package sn.kai.kaivoiture.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.Entites.Vehicules;

import javax.persistence.*;
import java.util.Collection;

@Data
public class ModeleDto {
    private int id;
    private String libellet;
    private Marque marque;
    private TypesVehicules typesVehicules;
   
}
