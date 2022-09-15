package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.TypesJobDeMaintenanceDTO;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.TypesJobDeMaintenance;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.TypesJobDeMaintenanceMapperIplement;
import sn.kai.kaivoiture.Repository.TypesJopMaintenaceRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TypesJopMaintenaceImplement implements ItypesJopMaintenaceService {
   TypesJobDeMaintenanceMapperIplement typesJobDeMaintenanceMapperIplement;
    TypesJopMaintenaceRepository typesJobDeMaintenanceRepository;
    @Override
    public TypesJobDeMaintenanceDTO save(TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO) {
        TypesJobDeMaintenance typesJobDeMaintenance= typesJobDeMaintenanceMapperIplement.fromTypesJobDeMaintenanceDto(typesJobDeMaintenanceDTO);
        TypesJobDeMaintenance typesJobDeMaintenance1=typesJobDeMaintenanceRepository.save(typesJobDeMaintenance);
        return typesJobDeMaintenanceMapperIplement.fromTypesJobDeMaintenance(typesJobDeMaintenance1);

    }

    @Override
    public Collection<TypesJobDeMaintenanceDTO> findAll() {
        Collection<TypesJobDeMaintenance> typesJobDeMaintenaces=typesJobDeMaintenanceRepository.findAll();
        Collection<TypesJobDeMaintenanceDTO> typesJobDeMaintenaceDTOs=typesJobDeMaintenaces.stream().map(typesJobDeMaintenanceMapperIplement::fromTypesJobDeMaintenance).collect(Collectors.toList());
        return typesJobDeMaintenaceDTOs;
    }

    @Override
    public TypesJobDeMaintenanceDTO findById(int id) throws VehiculeExceptionEdite {
        TypesJobDeMaintenance typesJobDeMaintenance=typesJobDeMaintenanceRepository.findById(id).orElse(null);
        if (typesJobDeMaintenance==null){
            throw new VehiculeExceptionEdite("type de maintenance introuvable");
        }
        typesJobDeMaintenanceRepository.findById(id);
        return typesJobDeMaintenanceMapperIplement.fromTypesJobDeMaintenance(typesJobDeMaintenance);
    }

    @Override
    public void delete(int id) {
        typesJobDeMaintenanceRepository.deleteById(id);

    }

    @Override
    public TypesJobDeMaintenanceDTO update(TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO) {
     TypesJobDeMaintenance typesJobDeMaintenance= typesJobDeMaintenanceMapperIplement.fromTypesJobDeMaintenanceDto(typesJobDeMaintenanceDTO);
        TypesJobDeMaintenance typesJobDeMaintenance1=typesJobDeMaintenanceRepository.save(typesJobDeMaintenance);
        return typesJobDeMaintenanceMapperIplement.fromTypesJobDeMaintenance(typesJobDeMaintenance1);

    }
}
