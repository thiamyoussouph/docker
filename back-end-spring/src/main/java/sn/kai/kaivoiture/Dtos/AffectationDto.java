package sn.kai.kaivoiture.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Chauffeur;
import sn.kai.kaivoiture.Entites.Vehicules;

import javax.persistence.*;
import java.util.Date;


@Data
public class AffectationDto {

    private  int id;
    private Date dateDebut;
    private  Date dateFin;
    private Vehicules vehicules;
    private Chauffeur chauffeur;
}
