package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Exception.*;

import java.util.Collection;

public interface IVehiculeService {
    VehiculesDto saveVehicule(VehiculesDto vehiculesDto) throws MarquenotFondException;



    Collection<VehiculesDto> listvehicule();
    public void  deletevehicule(int id);
    VehiculesDto update( VehiculesDto vehiculesDto) throws VehiculeException;

    VehiculesDto edite(int id) throws VehiculeExceptionEdite;




    long vehiculeenmarchefalse();
    long vehiculenpane();
    long vehiculepasenpanne();



}
