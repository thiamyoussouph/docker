package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.PannesVehiculeDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.service.PanneVehiculeImplement;


import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PanneVeiculeController {
    private PanneVehiculeImplement panneVehiculeImplement;
    @GetMapping("/panneenregistrer")
    public Collection<PannesVehiculeDto> pannesVehicules(){

        return panneVehiculeImplement.findall();

    }
    @PostMapping("/creerpannes")
    public PannesVehiculeDto ajoutPannevhicule(@RequestBody PannesVehiculeDto pannesVehiculeDto){
int vehiculeid=pannesVehiculeDto.getVehicules().getId();
        return panneVehiculeImplement.savepanneve(pannesVehiculeDto,vehiculeid);
    }
        @PutMapping("/updatePannevehicule/{id}")
    public PannesVehiculeDto updatePannevehiculevehicule(@PathVariable(value = "id")int id,@RequestBody PannesVehiculeDto pannesVehiculeDto, VehiculesDto vehiculesDto) {
        pannesVehiculeDto.setId(id);
        return   panneVehiculeImplement.update(id,pannesVehiculeDto,vehiculesDto);
    }
    @GetMapping("editerpannevehicule/{id}")
    public PannesVehiculeDto edite(@PathVariable(value = "id")int id) {
        return panneVehiculeImplement.findbyid(id);
    }

    @DeleteMapping("/suprimerpannevehicule/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        panneVehiculeImplement.deletePannevehicule(id);
    }
 @PutMapping("/resolutionpanne/{id}")
    public PannesVehiculeDto resolutionpanne(@PathVariable(value = "id")int id,@RequestBody PannesVehiculeDto pannesVehiculeDto) {

     int vehiculeid=pannesVehiculeDto.getVehicules().getId();
        pannesVehiculeDto.setId(id);
        return panneVehiculeImplement.resolutionpannevehicule(pannesVehiculeDto,vehiculeid,id);
    }

}
