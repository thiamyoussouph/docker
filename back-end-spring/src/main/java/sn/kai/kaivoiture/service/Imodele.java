package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.ModeleDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;

import java.util.Collection;

public interface Imodele {
    Collection<ModeleDto> ListeModele();
}
