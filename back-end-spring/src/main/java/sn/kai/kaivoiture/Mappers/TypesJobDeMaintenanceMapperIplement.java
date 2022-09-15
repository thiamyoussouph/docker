package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.TypesJobDeMaintenanceDTO;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.TypesJobDeMaintenance;
import sn.kai.kaivoiture.Entites.Vehicules;

@Service
public class TypesJobDeMaintenanceMapperIplement {
    public TypesJobDeMaintenanceDTO fromTypesJobDeMaintenance(TypesJobDeMaintenance typesJobDeMaintenance){
        TypesJobDeMaintenanceDTO jobDeMaintenanceDTO=new TypesJobDeMaintenanceDTO();
        BeanUtils.copyProperties(typesJobDeMaintenance,jobDeMaintenanceDTO);
        return jobDeMaintenanceDTO;
    }
    public TypesJobDeMaintenance fromTypesJobDeMaintenanceDto(TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO){
        TypesJobDeMaintenance typesJobDeMaintenance=new TypesJobDeMaintenance();
        BeanUtils.copyProperties(typesJobDeMaintenanceDTO,typesJobDeMaintenance);
        return typesJobDeMaintenance;
    }

}
