package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.MarqueDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Marque;


import java.util.Collection;

public interface Imarque {
    Collection<MarqueDto > ListeMarque();
    MarqueDto edite(int id);
}
