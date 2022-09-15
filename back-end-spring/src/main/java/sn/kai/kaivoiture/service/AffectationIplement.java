package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.AffectationDto;
import sn.kai.kaivoiture.Entites.Affectation;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.AffectationMapperImplement;
import sn.kai.kaivoiture.Repository.AffectationRepository;
;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AffectationIplement implements IaffectationService{
    AffectationRepository affectationRepository;
    AffectationMapperImplement affectationMapperImplement;
    @Override
    public Collection<AffectationDto> Listeaffection() {
        Collection<Affectation>affectations=affectationRepository.findAll();
        Collection<AffectationDto> affectationDtos= affectations.stream().map(affectation -> affectationMapperImplement.fromAffectation(affectation)).collect(Collectors.toList());
        return affectationDtos;


    }

    @Override
    public AffectationDto saveaffectation(AffectationDto affectationDto) {
        Affectation affectation=affectationMapperImplement.fromAffectationDto(affectationDto);
        Affectation affectation1=affectationRepository.save(affectation);
        return affectationMapperImplement.fromAffectation(affectation1);



    }

    @Override
    public void deleteAffactation(int id) {
          affectationRepository.deleteById(id);
    }

    @Override
    public AffectationDto update(AffectationDto affectationDto) {
        Affectation affectation=affectationMapperImplement.fromAffectationDto(affectationDto);
        Affectation affectation1=affectationRepository.save(affectation);
        return affectationMapperImplement.fromAffectation(affectation1);

    }

    @Override
    public AffectationDto edite(int id) throws VehiculeExceptionEdite {
        Affectation affectation=affectationRepository.findById(id).orElse(null);
        if (affectation==null)
            throw new VehiculeExceptionEdite("le non du model existe deja ");
            affectationRepository.findById(id);
        return affectationMapperImplement.fromAffectation(affectation);
    }

}
