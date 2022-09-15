package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.MarqueDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.MarqueMapperImplement;
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
public class MarqueImplement implements Imarque{
    private MarqueReposirory marqueReposirory;
    private MarqueMapperImplement marqueMapperImplement;

    @Override
    public Collection<MarqueDto> ListeMarque() {
        Collection<Marque>marques= marqueReposirory.findAll();
        Collection<MarqueDto> marqueDtos=marques.stream().map(marque -> marqueMapperImplement.fromMarque(marque)).collect(Collectors.toList());

        return marqueDtos;
    }

    @Override
    public MarqueDto edite(int id) {
        Marque marque=marqueReposirory.findById(id).orElse(null);
   marqueReposirory.findById(id);
        return marqueMapperImplement.fromMarque(marque);



    }
}
