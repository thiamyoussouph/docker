package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.TypesJobDeMaintenanceDTO;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.service.TypesJopMaintenaceImplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class TypesJobDeMaintenanceController {
    TypesJopMaintenaceImplement typesJopMaintenaceImplement;
    @GetMapping("/typesmaintenances")
   public Collection<TypesJobDeMaintenanceDTO> typesmaintenances(){

            return typesJopMaintenaceImplement.findAll();
    }
    @PostMapping ("/savetypesmaintenances")
    public TypesJobDeMaintenanceDTO ajouttypesmaintenances(@RequestBody TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO) throws VehiculeExceptionEdite {

        return typesJopMaintenaceImplement.save(typesJobDeMaintenanceDTO);


    }
    @PutMapping("/updateTypesmaintenances/{id}")
    public TypesJobDeMaintenanceDTO updatetypesmaintenances(@PathVariable(value = "id")int id,@RequestBody TypesJobDeMaintenanceDTO typesJobDeMaintenanceDTO) throws VehiculeExceptionEdite {
        typesJobDeMaintenanceDTO.setId(id);
      return   typesJopMaintenaceImplement.update(typesJobDeMaintenanceDTO);
    }
    @GetMapping("/typesmaintenances/{id}")
    public TypesJobDeMaintenanceDTO typesmaintenances(@PathVariable(value = "id") int id) throws VehiculeExceptionEdite, VehiculeExceptionEdite {
        return typesJopMaintenaceImplement.findById(id);
    }
        @DeleteMapping("/suprimerTypesmainenaces/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        typesJopMaintenaceImplement.delete(id);
    }
}
