package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs extends Event {

    private Date fin;
    @ManyToOne
    private TypesJobDeMaintenance typesJobDeMaintenance;


}
