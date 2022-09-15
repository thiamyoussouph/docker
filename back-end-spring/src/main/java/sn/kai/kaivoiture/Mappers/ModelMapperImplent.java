package sn.kai.kaivoiture.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.ModeleDto;
import sn.kai.kaivoiture.Entites.Modele;

@Service
public class ModelMapperImplent {
    public ModeleDto fromModeles(Modele modele){
        ModeleDto modeleDto=new ModeleDto();
        BeanUtils.copyProperties(modele,modeleDto);
        return modeleDto;
    }
    public Modele fromModelsDto(ModeleDto modeleDto){
        Modele modele=new Modele();
        BeanUtils.copyProperties(modeleDto,modele);
        return modele;
    }
}
