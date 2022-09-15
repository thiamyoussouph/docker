package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Dtos.AffectationDto;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;


import java.util.Collection;

public interface IaffectationService {
    Collection<AffectationDto> Listeaffection() ;

    AffectationDto saveaffectation(AffectationDto affectationDto);

    public void  deleteAffactation(int id);

    AffectationDto update(AffectationDto affectationDto) ;

    AffectationDto edite(int id) throws VehiculeExceptionEdite;


}
