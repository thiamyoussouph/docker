package sn.kai.kaivoiture.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.PannesVehiculeDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.PannesVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Mappers.PannesVehiculeMapperImplement;
import sn.kai.kaivoiture.Mappers.VehiculesMapperIplement;
import sn.kai.kaivoiture.Repository.PanneVehiculeRepository;
import sn.kai.kaivoiture.Repository.VehiculeRepository;
import sn.kai.kaivoiture.enums.Nievau;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static sn.kai.kaivoiture.enums.Nievau.HAUT;
import static sn.kai.kaivoiture.enums.VehiculeSatus.Actif;
import static sn.kai.kaivoiture.enums.VehiculeSatus.Innactif;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PanneVehiculeImplement implements IPannevehiculeService{
    PanneVehiculeRepository panneVehiculeRepository;
    VehiculeRepository vehiculeRepository;
    VehiculeImplemente vehiculeImplemente;
    PannesVehiculeMapperImplement pannesVehiculeMapperImplement;
    VehiculesMapperIplement vehiculesMapperIplement;
    @Override
    public PannesVehiculeDto savepannevehicule(PannesVehiculeDto pannesVehiculeDto) {
        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }

    @Override
    public Collection<PannesVehiculeDto> findall() {
        Collection<PannesVehicule>pannesVehicules= panneVehiculeRepository.findAll();
        Collection<PannesVehiculeDto> pannesVehiculeDtos= pannesVehicules.stream().map(pannesVehicule ->pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule)).collect(Collectors.toList());
        return pannesVehiculeDtos;



    }

    @Override
    public PannesVehiculeDto findbyid(int id) {
        PannesVehicule pannesVehicule=panneVehiculeRepository.findById(id).orElse(null);
        panneVehiculeRepository.findById(id);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule);

    }

    @Override
    public PannesVehiculeDto update(int id, PannesVehiculeDto pannesVehiculeDto, VehiculesDto vehiculesDto) {
        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }

    @Override
    public PannesVehiculeDto savepanneve(PannesVehiculeDto pannesVehiculeDto, int vehiculeid) {

        PannesVehicule pannesVehicule=pannesVehiculeMapperImplement.fromPanneVehiculeDto(pannesVehiculeDto);
    Vehicules vehicule= vehiculeRepository.findById(vehiculeid).orElseThrow();
    if (pannesVehicule.getNiveau()==HAUT){
        vehicule.setStatus(Innactif);
   }

        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);

        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }

    @Override
    public PannesVehiculeDto resolutionpannevehicule(PannesVehiculeDto pannesVehiculeDto, int vehiculeid,int id) {

        PannesVehicule pannesVehicule=panneVehiculeRepository.findById(id).orElseThrow();
        pannesVehicule.setEtat(true);
        pannesVehicule.setDateResolution(new Date());
        AtomicInteger compteurNonResolue= new AtomicInteger();
        AtomicInteger compteurResolue= new AtomicInteger();
        AtomicInteger compteurpanneHaut= new AtomicInteger();


        Vehicules vehicule= vehiculeRepository.findById(vehiculeid).orElseThrow();
        vehicule.getPannesVehicules().forEach(pannesVehicule1 -> {


            if(pannesVehicule1.isEtat()==false){
                compteurNonResolue.set(compteurNonResolue.get() + 1);
                if (pannesVehicule1.getNiveau()==HAUT){
                    compteurpanneHaut.set(compteurpanneHaut.get()+1);
                }
            }else {
                compteurResolue.set(compteurResolue.get() + 1);
            }
        });

        if(compteurpanneHaut.get()>0){
            vehicule.setStatus(Innactif);
            log.info("vehicule innactif");
        }else {
            vehicule.setStatus(Actif);
            log.info("vehicule actif");
        }


        PannesVehicule pannesVehicule1=panneVehiculeRepository.save(pannesVehicule);
        panneVehiculeRepository.save(pannesVehicule1);
        return pannesVehiculeMapperImplement.frompanneVeicule(pannesVehicule1);
    }


    @Override
    public void deletePannevehicule(int id) {
        panneVehiculeRepository.deleteById(id);
    }

}
