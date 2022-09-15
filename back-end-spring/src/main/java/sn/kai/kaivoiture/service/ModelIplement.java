package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.ModeleDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Mappers.ModelMapperImplent;
import sn.kai.kaivoiture.Repository.ModeleRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ModelIplement implements Imodele {
    private ModeleRepository modeleRepository;
    private ModelMapperImplent modelMapperImplent;
    @Override
    public Collection<ModeleDto> ListeModele() {
        Collection<Modele>modeles= modeleRepository.findAll();
        Collection<ModeleDto> modeleDtos= modeles.stream().map(modele ->modelMapperImplent.fromModeles(modele)).collect(Collectors.toList());
        return modeleDtos;
    }


}
