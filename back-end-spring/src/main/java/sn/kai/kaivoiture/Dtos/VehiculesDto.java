package sn.kai.kaivoiture.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.Entites.*;
import sn.kai.kaivoiture.enums.VehiculeSatus;
import sn.kai.kaivoiture.enums.vehiculeEtats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Data
public class VehiculesDto {

    private  int id;
    private String Numerochassie;
    private String Matricule;
    private int NombrePlace;
    private Date dateSOrtie;
    private Date DateMisEnMarche;
    private Date DateAchat;
    private String TypesCarburant;
    private VehiculeSatus status;
    private vehiculeEtats Etats;
    private boolean etatpanne;
    private boolean enmarche;
    private Modele modele;
    private Collection<PannesVehicule>pannesVehicules;
    private Collection<Affectation>affectations;
    private Collection<KilometrageVehicule>kilometrageVehicules;


}
