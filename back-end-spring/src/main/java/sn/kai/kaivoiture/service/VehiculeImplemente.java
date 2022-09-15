package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.*;
import sn.kai.kaivoiture.Mappers.VehiculesMapperIplement;
import sn.kai.kaivoiture.Repository.MarqueReposirory;
import sn.kai.kaivoiture.Repository.ModeleRepository;
import sn.kai.kaivoiture.Repository.TypesVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VehiculeImplemente implements IVehiculeService {
    private MarqueReposirory marqueReposirory;
    private ModeleRepository modeleRepository;
    private TypesVehiculeRepository typesVehiculeRepository;
    private VehiculeRepository vehiculeRepository;
    private VehiculesMapperIplement dtopMapper;

    @Override
    public VehiculesDto saveVehicule(VehiculesDto vehiculesDto) throws MarquenotFondException {
    Vehicules vehicules=dtopMapper.fromVehiculesDto(vehiculesDto);
    Vehicules savevehicule=vehiculeRepository.save(vehicules);
        return dtopMapper.fromVehicules(savevehicule);
    }




    @Override
    public Collection<VehiculesDto> listvehicule() {
        Collection<Vehicules>vehicules= vehiculeRepository.findAll();
        Collection<VehiculesDto> vehiculesDto= vehicules.stream().map(vehicule ->dtopMapper.fromVehicules(vehicule)).collect(Collectors.toList());
        return vehiculesDto;
    }

    @Override
    public void deletevehicule(int id) {
        vehiculeRepository.deleteById(id);
    }


    @Override
    public VehiculesDto update( VehiculesDto vehiculesDto) throws VehiculeException {
        Vehicules vehicules=dtopMapper.fromVehiculesDto(vehiculesDto);
        Vehicules savevehicule=vehiculeRepository.save(vehicules);
        return dtopMapper.fromVehicules(savevehicule);
    }

    @Override
    public VehiculesDto edite(int id) throws VehiculeExceptionEdite {
        Vehicules vehicules=vehiculeRepository.findById(id).orElse(null);
        if (vehicules==null)
            throw new VehiculeExceptionEdite("le non du model existe deja ");
        vehiculeRepository.findById(id);
        return dtopMapper.fromVehicules(vehicules);
    }




    @Override
    public long vehiculeenmarchefalse() {
        return vehiculeRepository.countVehiculesByEnmarcheIsFalse();
    }

    @Override
    public long vehiculenpane() {
        return vehiculeRepository.countVehiculesByEtatpanneIsTrue();
    }

    @Override
    public long vehiculepasenpanne() {
        return vehiculeRepository.countVehiculesByEtatpanneIsFalse();
    }






}
