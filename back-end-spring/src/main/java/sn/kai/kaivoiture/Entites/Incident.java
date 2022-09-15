package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.kai.kaivoiture.enums.IMmpacte;
import sn.kai.kaivoiture.enums.Urgence;

import javax.persistence.*;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public  class Incident extends Event {
    @Enumerated(EnumType.STRING)
    private IMmpacte impacte;
    @Enumerated(EnumType.STRING)
    private Urgence urgence;
    private String cause;


}
