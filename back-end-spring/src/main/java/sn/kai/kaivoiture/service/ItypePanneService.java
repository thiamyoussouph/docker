package sn.kai.kaivoiture.service;


import sn.kai.kaivoiture.Dtos.TypesPannesDto;


import java.util.Collection;


public interface ItypePanneService {
    TypesPannesDto savepanne(TypesPannesDto typesPannesDto);
   Collection<TypesPannesDto> listPanne();
    TypesPannesDto findbyid(int id);
    TypesPannesDto update( TypesPannesDto typesPannesDto);
   void delete(int id);

}
