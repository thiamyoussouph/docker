package sn.kai.kaivoiture.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.Affectation;

import javax.persistence.*;
import java.util.Collection;


@Data
public class ChauffeurDto {
    private int id;
    private String noms;
    private  String prenoms;
    private String adresse;

}
