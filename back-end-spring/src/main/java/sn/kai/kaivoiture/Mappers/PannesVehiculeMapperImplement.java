package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.PannesVehiculeDto;
import sn.kai.kaivoiture.Entites.PannesVehicule;

@Service
public class PannesVehiculeMapperImplement {

    public PannesVehiculeDto frompanneVeicule(PannesVehicule pannesVehicule){
        PannesVehiculeDto pannesVehiculeDto=new PannesVehiculeDto();
        BeanUtils.copyProperties(pannesVehicule,pannesVehiculeDto);
        return pannesVehiculeDto;
    }
    public PannesVehicule  fromPanneVehiculeDto(PannesVehiculeDto pannesVehiculeDto){
        PannesVehicule pannesVehicule=new PannesVehicule();
        BeanUtils.copyProperties(pannesVehiculeDto,pannesVehicule);
        return pannesVehicule;
    }
}
