package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.TypesVehiculesDto;

import sn.kai.kaivoiture.Entites.TypesVehicules;


@Service
public class TypesVehiculeMapperIplement {

    public TypesVehiculesDto fromTypesVehicule(TypesVehicules typesVehicules){
        TypesVehiculesDto typesVehiculesDto=new TypesVehiculesDto();
        BeanUtils.copyProperties(typesVehicules,typesVehiculesDto);
        return typesVehiculesDto;
    }
    public TypesVehicules fromTypesVehiculDto(TypesVehiculesDto typesVehiculesDto){
        TypesVehicules typesVehicules=new TypesVehicules();
        BeanUtils.copyProperties(typesVehiculesDto,typesVehicules);
        return typesVehicules;
    }
}
