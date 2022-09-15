package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.ChauffeurDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Chauffeur;
import sn.kai.kaivoiture.Entites.Vehicules;
@Service
public class ChauffeurMpperseImplements {
    public ChauffeurDto fromchauffeur(Chauffeur chauffeur){
        ChauffeurDto chauffeurDto=new ChauffeurDto();
        BeanUtils.copyProperties(chauffeur,chauffeurDto);
        return chauffeurDto;
    }
    public Chauffeur fromChauffeurDto(ChauffeurDto chauffeurDto){
        Chauffeur chauffeur=new Chauffeur();
        BeanUtils.copyProperties(chauffeurDto,chauffeur);
        return chauffeur;
    }
}
