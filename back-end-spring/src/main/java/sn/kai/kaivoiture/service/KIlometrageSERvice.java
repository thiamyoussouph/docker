package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.KilometrageVehiculeDto;
import sn.kai.kaivoiture.Entites.KilometrageVehicule;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;

import java.util.Collection;

public interface KIlometrageSERvice {
    Collection<KilometrageVehiculeDto>listeKilometrage();
    KilometrageVehiculeDto getKilometrage(int id) throws VehiculeExceptionEdite;

    KilometrageVehiculeDto saveKilometrage(KilometrageVehiculeDto kilometrageVehiculeDto);
    KilometrageVehiculeDto updateKilometrage(KilometrageVehiculeDto kilometrageVehiculeDto);
    void deleteKilometrage(int id);

}
