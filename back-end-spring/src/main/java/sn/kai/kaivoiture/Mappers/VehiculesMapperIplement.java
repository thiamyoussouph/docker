package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Vehicules;
@Service
public class VehiculesMapperIplement {
        public VehiculesDto fromVehicules(Vehicules vehicules){
        VehiculesDto vehiculesDto=new VehiculesDto();
        BeanUtils.copyProperties(vehicules,vehiculesDto);
     return vehiculesDto;
    }
    public Vehicules fromVehiculesDto(VehiculesDto vehiculesDto){
        Vehicules vehicules=new Vehicules();
        BeanUtils.copyProperties(vehiculesDto,vehicules);
        return vehicules;
    }
}
