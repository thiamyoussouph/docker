package sn.kai.kaivoiture.Dtos;


import lombok.Data;

import sn.kai.kaivoiture.Entites.TypesPannes;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.enums.Nievau;

import java.util.Date;


@Data
public class PannesVehiculeDto {
    private int id;
    private Date  date;
    private String lieux;
    private String description;
    private Vehicules vehicules;
    private boolean etat;
    private Date dateResolution;
    private TypesPannes Typespannes;
    private Nievau niveau;
}
