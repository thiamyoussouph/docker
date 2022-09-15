package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.AffectationDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Affectation;
import sn.kai.kaivoiture.Entites.Vehicules;
@Service
public class AffectationMapperImplement {
    public AffectationDto fromAffectation(Affectation affectation){
       AffectationDto affectationDto=new AffectationDto();
        BeanUtils.copyProperties(affectation,affectationDto);
        return affectationDto;
    }
    public Affectation fromAffectationDto(AffectationDto affectationDto){
        Affectation affectation=new Affectation();
        BeanUtils.copyProperties(affectationDto,affectation);
        return affectation;
    }
}
