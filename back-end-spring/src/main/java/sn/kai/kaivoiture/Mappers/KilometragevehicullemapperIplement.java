package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Dtos.KilometrageVehiculeDto;

import sn.kai.kaivoiture.Entites.KilometrageVehicule;

@Service
public class KilometragevehicullemapperIplement {
    public KilometrageVehiculeDto fromkilometragevehicule(KilometrageVehicule kilometrageVehicule){
        KilometrageVehiculeDto kilometrageVehiculeDto=new KilometrageVehiculeDto();
        BeanUtils.copyProperties(kilometrageVehicule,kilometrageVehiculeDto);
        return kilometrageVehiculeDto;
    }
    public KilometrageVehicule fromkilometragevehiculeDto(KilometrageVehiculeDto kilometrageVehiculeDto){
        KilometrageVehicule kilometrageVehicule=new KilometrageVehicule();
        BeanUtils.copyProperties(kilometrageVehiculeDto,kilometrageVehicule);
        return kilometrageVehicule;
    }
}
