package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.KilometrageVehiculeDto;
import sn.kai.kaivoiture.Exception.MarquenotFondException;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.service.KilometrageServiceImplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class KilometrageVehiCulecontroller {
    @Autowired
    private KilometrageServiceImplement kilometrageServiceImplement;
    @GetMapping("/killometrages")
    public Collection<KilometrageVehiculeDto> kilometragevehicules(){
        return kilometrageServiceImplement.listeKilometrage();
    }
    @PostMapping ("/ajoutkilometrage")
    public KilometrageVehiculeDto ajoutkilometrage(@RequestBody KilometrageVehiculeDto kilometrageVehiculeDto) throws MarquenotFondException {
        return kilometrageServiceImplement.saveKilometrage(kilometrageVehiculeDto);
    }
    @PutMapping("/updatekilometrage/{id}")
    public KilometrageVehiculeDto updatekilometrage(@PathVariable(value = "id")int id,@RequestBody KilometrageVehiculeDto kilometrageVehiculeDto) throws MarquenotFondException {
        kilometrageVehiculeDto.setId(id);
        return   kilometrageServiceImplement.updateKilometrage(kilometrageVehiculeDto);
    }
    @GetMapping("/editerkilometrage/{id}")
    public KilometrageVehiculeDto editerkilometrage(@PathVariable(value = "id")int id) throws MarquenotFondException, VehiculeExceptionEdite {
        return kilometrageServiceImplement.getKilometrage(id);
    }
    @DeleteMapping("/supprimerkilometrage/{id}")
    public void supprimerkilometrage(@PathVariable(value = "id") int id){
        kilometrageServiceImplement.deleteKilometrage(id);

    }
}
