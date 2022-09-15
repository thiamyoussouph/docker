package sn.kai.kaivoiture.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Modele;

import javax.persistence.*;
import java.util.Collection;


@Data
public class TypesVehiculesDto {
    private int id;
    private String libellet;
    private Collection<Modele>modeles;
}
