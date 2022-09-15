package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.TypesVehiculesDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Mappers.TypesVehiculeMapperIplement;
import sn.kai.kaivoiture.Repository.TypesVehiculeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TypesVehiculeImplement implements ItypesVehicule {
    TypesVehiculeRepository typesVehiculeRepository;
    private TypesVehiculeMapperIplement typesVehiculeMapperIplement;
    @Override
    public Collection<TypesVehiculesDto> ListetypesVehicule() {
        Collection<TypesVehicules>typesVehicules= typesVehiculeRepository.findAll();
        Collection<TypesVehiculesDto> typesVehiculesDtos= typesVehicules.stream().map(typesVehicules1->typesVehiculeMapperIplement.fromTypesVehicule(typesVehicules1)).collect(Collectors.toList());
        return typesVehiculesDtos;
    }

}
