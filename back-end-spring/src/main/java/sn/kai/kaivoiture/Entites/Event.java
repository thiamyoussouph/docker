package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Event  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datedebut;
    private String lieu;

    @ManyToOne
    private Vehicules vehicules;


}
