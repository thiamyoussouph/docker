package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.ChauffeurDto;

import java.util.Collection;

public interface Ichauffeur {
    ChauffeurDto addChauffeur(ChauffeurDto chauffeurDto);
    ChauffeurDto updateChauffeur(ChauffeurDto chauffeurDto);
     void deleteChauffeur(int id);
     ChauffeurDto getChauffeur(int id);
    Collection<ChauffeurDto> getAllChauffeur();
}
