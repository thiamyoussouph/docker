package sn.kai.kaivoiture.Dtos;


import lombok.Data;

import sn.kai.kaivoiture.Entites.Modele;


import java.util.Collection;


@Data
public class MarqueDto {
    private int id;
    private String libellet;
    private Collection<Modele>modeles;

}
