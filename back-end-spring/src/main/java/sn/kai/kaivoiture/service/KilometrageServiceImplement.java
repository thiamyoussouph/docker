package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Dtos.KilometrageVehiculeDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.KilometrageVehicule;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Mappers.KilometragevehicullemapperIplement;
import sn.kai.kaivoiture.Repository.KilometrageRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class KilometrageServiceImplement implements KIlometrageSERvice{
    private KilometrageRepository kilometrageRepository;
    private  KilometragevehicullemapperIplement kilometragevehicullemapperIplement;
    @Override
    public Collection<KilometrageVehiculeDto> listeKilometrage() {
        Collection<KilometrageVehicule>kilometrageVehicules= kilometrageRepository.findAll();
        Collection<KilometrageVehiculeDto> kilometrageVehiculeDtos= kilometrageVehicules.stream().map(kilometrageVehicule ->kilometragevehicullemapperIplement.fromkilometragevehicule(kilometrageVehicule)).collect(Collectors.toList());
        return kilometrageVehiculeDtos;
    }

    @Override
    public KilometrageVehiculeDto getKilometrage(int id) throws VehiculeExceptionEdite {
        KilometrageVehicule kilometrageVehicule=kilometrageRepository.findById(id).orElse(null);
        if (kilometrageVehicule==null)
            throw new VehiculeExceptionEdite("le non du model existe deja ");
        kilometrageRepository.findById(id);
        return kilometragevehicullemapperIplement.fromkilometragevehicule(kilometrageVehicule);
    }

    @Override
    public KilometrageVehiculeDto saveKilometrage(KilometrageVehiculeDto kilometrageVehiculeDto) {
        KilometrageVehicule kilometrageVehicule=kilometragevehicullemapperIplement.fromkilometragevehiculeDto(kilometrageVehiculeDto);
        KilometrageVehicule savekilometrage=kilometrageRepository.save(kilometrageVehicule);
        return kilometragevehicullemapperIplement.fromkilometragevehicule(savekilometrage);

    }


    @Override
    public KilometrageVehiculeDto updateKilometrage(KilometrageVehiculeDto kilometrageVehiculeDto) {
        KilometrageVehicule kilometrageVehicule=kilometragevehicullemapperIplement.fromkilometragevehiculeDto(kilometrageVehiculeDto);
        KilometrageVehicule kilometrageVehicules=kilometrageRepository.save(kilometrageVehicule);
        return kilometragevehicullemapperIplement.fromkilometragevehicule(kilometrageVehicules);


    }

    @Override
    public void deleteKilometrage(int id) {
        kilometrageRepository.deleteById(id);

    }
}
