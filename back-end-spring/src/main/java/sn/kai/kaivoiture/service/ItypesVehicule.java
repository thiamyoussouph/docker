package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.TypesVehiculesDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.TypesVehicules;

import java.util.Collection;

public interface ItypesVehicule {
    Collection<TypesVehiculesDto> ListetypesVehicule();
}
