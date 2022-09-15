package sn.kai.kaivoiture.service;


import sn.kai.kaivoiture.Dtos.PannesVehiculeDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;

import java.util.Collection;

public interface IPannevehiculeService {
    PannesVehiculeDto savepannevehicule(PannesVehiculeDto pannesVehiculeDto);
    Collection<PannesVehiculeDto> findall();
    PannesVehiculeDto findbyid(int id);
    PannesVehiculeDto update(int id, PannesVehiculeDto pannesVehiculeDto, VehiculesDto vehiculesDto);
    PannesVehiculeDto savepanneve( PannesVehiculeDto pannesVehiculeDto, int id);
   PannesVehiculeDto resolutionpannevehicule(PannesVehiculeDto pannesVehiculeDto, int id ,int vehiculeid);
    public  void  deletePannevehicule(int id);
}
