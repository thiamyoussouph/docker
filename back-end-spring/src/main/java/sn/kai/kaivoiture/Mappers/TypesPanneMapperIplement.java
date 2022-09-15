package sn.kai.kaivoiture.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import sn.kai.kaivoiture.Dtos.TypesPannesDto;

import sn.kai.kaivoiture.Entites.TypesPannes;

@Service
public class TypesPanneMapperIplement {

    public TypesPannesDto fromPanne(TypesPannes pannes){
        TypesPannesDto typesPannesDto=new TypesPannesDto();
        BeanUtils.copyProperties(pannes,typesPannesDto);
        return typesPannesDto;
    }
    public TypesPannes fromPannesDto(TypesPannesDto typesPannesDto){
        TypesPannes typesPannes=new TypesPannes();
        BeanUtils.copyProperties(typesPannesDto,typesPannes);
        return typesPannes;
    }
}
