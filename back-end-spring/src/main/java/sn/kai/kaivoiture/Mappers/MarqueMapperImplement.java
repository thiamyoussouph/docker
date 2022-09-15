package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.MarqueDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Vehicules;
@Service
public class MarqueMapperImplement {
    public MarqueDto fromMarque(Marque marque){
        MarqueDto marqueDto=new MarqueDto();
        BeanUtils.copyProperties(marque,marqueDto);
        return marqueDto;
    }
    public Marque fromMarqueDTO(MarqueDto marqueDto){
        Marque marque=new Marque();
        BeanUtils.copyProperties(marqueDto,marque);
        return marque;
    }
}
