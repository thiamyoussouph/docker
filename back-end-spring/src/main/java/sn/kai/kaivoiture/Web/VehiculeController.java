package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.Exception.MarquenotFondException;
import sn.kai.kaivoiture.Exception.VehiculeException;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.Repository.VehiculeRepository;
import sn.kai.kaivoiture.enums.TypesCarburant;
import sn.kai.kaivoiture.service.VehiculeImplemente;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class VehiculeController {
    VehiculeRepository vehiculeRepository;
    @Autowired
    private VehiculeImplemente vehiculeImplemente;
    @GetMapping("/affiche")
public Collection<VehiculesDto> vehicules(){

    return vehiculeImplemente.listvehicule();

}

    @PostMapping ("/ajout")
    public VehiculesDto ajoutvehicules(@RequestBody VehiculesDto vehiculesDto) throws MarquenotFondException {

        return vehiculeImplemente.saveVehicule(vehiculesDto);


    }
@PutMapping("/updateVehicule/{id}")
public VehiculesDto updatevehicule(@PathVariable(value = "id")int id,@RequestBody VehiculesDto vehiculesDto) throws VehiculeException {
        vehiculesDto.setId(id);
      return   vehiculeImplemente.update(vehiculesDto);
}
    @GetMapping("editer/{id}")
public VehiculesDto edite(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
return vehiculeImplemente.edite(id);
}

@DeleteMapping("/suprimer/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        vehiculeImplemente.deletevehicule(id);
}


    @GetMapping("/enmarche")
    public long edite()  {
        return vehiculeRepository.countVehiculesByEnmarcheIsTrue();
    }
    @GetMapping("/enmarchefals")
    public long allvehiculeInnctif()  {
        return vehiculeImplemente.vehiculeenmarchefalse();
    }
    @GetMapping("/enpanne")
    public long allvehiculeenpanne()  {
        return vehiculeImplemente.vehiculenpane();
    }
    @GetMapping("/pasenpanne")
    public long allvehiculepaspanne()  {
        return vehiculeImplemente.vehiculepasenpanne();
    }




}

