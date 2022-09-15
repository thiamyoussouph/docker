package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.TypesJobDeMaintenanceDTO;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;

import java.util.Collection;

public interface ItypesJopMaintenaceService {
    TypesJobDeMaintenanceDTO save(TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO);
    Collection<TypesJobDeMaintenanceDTO> findAll();
    TypesJobDeMaintenanceDTO findById(int id) throws VehiculeExceptionEdite;
    void delete(int id);
    TypesJobDeMaintenanceDTO update(TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO);




}
