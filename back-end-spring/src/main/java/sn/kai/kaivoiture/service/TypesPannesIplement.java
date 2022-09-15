package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.kai.kaivoiture.Dtos.TypesPannesDto;

import sn.kai.kaivoiture.Entites.TypesPannes;

import sn.kai.kaivoiture.Mappers.TypesPanneMapperIplement;

import sn.kai.kaivoiture.Repository.TypesPanneRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TypesPannesIplement  implements ItypePanneService{
    TypesPanneRepository typesPanneRepository;

    TypesPanneMapperIplement panneMapperIplement;

    @Override
    public TypesPannesDto savepanne(TypesPannesDto typesPannesDto) {
        TypesPannes pannes=panneMapperIplement.fromPannesDto(typesPannesDto);
        TypesPannes pannes1=typesPanneRepository.save(pannes);
        return panneMapperIplement.fromPanne(pannes1);
    }




    @Override
    public Collection<TypesPannesDto> listPanne() {
        Collection<TypesPannes>pannes= typesPanneRepository.findAll();
        Collection<TypesPannesDto> pannesDtos= pannes.stream().map(panne ->panneMapperIplement.fromPanne(panne)).collect(Collectors.toList());
        return pannesDtos;
    }


    @Override
    public TypesPannesDto findbyid(int id) {
        TypesPannes pannes=typesPanneRepository.findById(id).orElse(null);
        typesPanneRepository.findById(id);
        return panneMapperIplement.fromPanne(pannes);
    }

    @Override
    public TypesPannesDto update(TypesPannesDto typespannesDto) {
        TypesPannes pannes=panneMapperIplement.fromPannesDto(typespannesDto);
        TypesPannes panne=typesPanneRepository.save(pannes);
        return panneMapperIplement.fromPanne(panne);
    }

    @Override
    public void delete(int id) {
       typesPanneRepository.deleteById(id);
    }


}
