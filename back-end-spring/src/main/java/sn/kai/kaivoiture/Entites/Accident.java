package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.enums.IMmpacte;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accident extends Incident{
    private String description;



}
