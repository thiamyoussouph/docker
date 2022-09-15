package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panne extends Incident{
    private Date Resolution;
    @ManyToOne
    private TypesPannes typePanne;



}
