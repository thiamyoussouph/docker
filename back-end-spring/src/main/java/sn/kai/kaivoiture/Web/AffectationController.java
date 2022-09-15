package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.AffectationDto;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Exception.VehiculeException;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.service.AffectationIplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AffectationController {
    private AffectationIplement affectationIplement;
    @GetMapping("/affectations")
public Collection<AffectationDto> affectation(){

        return affectationIplement.Listeaffection();

    }
    @PostMapping("/saveAffectation")
    public AffectationDto ajoutAffectation(@RequestBody AffectationDto affectationDto)  {

        return affectationIplement.saveaffectation(affectationDto);
}
    @GetMapping("detaiAffectation/{id}")
    public AffectationDto edite(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
        return affectationIplement.edite(id);
    }
    @PutMapping("/updateAffectation/{id}")
    public AffectationDto updatevehicule(@PathVariable(value = "id")int id,@RequestBody AffectationDto affectationDto){
        affectationDto.setId(id);
        return   affectationIplement.update(affectationDto);
    }
    @DeleteMapping("/suprimerAffectation/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        affectationIplement.deleteAffactation(id);
    }
}
