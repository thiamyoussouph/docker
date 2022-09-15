package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.ChauffeurDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Chauffeur;

import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Mappers.ChauffeurMpperseImplements;
import sn.kai.kaivoiture.Repository.ChauffeurRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ChauffeurImplement implements Ichauffeur {
    ChauffeurMpperseImplements chauffeurMpperseImplements;
    ChauffeurRepository chauffeurRepository;
    @Override
    public ChauffeurDto addChauffeur(ChauffeurDto chauffeurDto) {

        Chauffeur chauffeur=chauffeurMpperseImplements.fromChauffeurDto(chauffeurDto);
        Chauffeur savechauffeur=chauffeurRepository.save(chauffeur);
        return chauffeurMpperseImplements.fromchauffeur(savechauffeur);
    }

    @Override
    public ChauffeurDto updateChauffeur(ChauffeurDto chauffeurDto) {
        Chauffeur chauffeur=chauffeurMpperseImplements.fromChauffeurDto(chauffeurDto);
        Chauffeur savechauffeur=chauffeurRepository.save(chauffeur);
        return chauffeurMpperseImplements.fromchauffeur(savechauffeur);

    }

    @Override
    public void deleteChauffeur(int id) { chauffeurRepository.deleteById(id);

    }

    @Override
    public ChauffeurDto getChauffeur(int id) {
      Chauffeur chauffeur=chauffeurRepository.findById(id).orElse(null);
        return chauffeurMpperseImplements.fromchauffeur(chauffeur);

    }

    @Override
    public Collection<ChauffeurDto> getAllChauffeur() {
         Collection<Chauffeur>chauffeurs=chauffeurRepository.findAll();
            Collection<ChauffeurDto>chauffeurDtos=chauffeurs.stream().map(chauffeur ->chauffeurMpperseImplements.fromchauffeur(chauffeur)).collect(Collectors.toList());
            return chauffeurDtos;
    }
}
