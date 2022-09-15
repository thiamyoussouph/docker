package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.ChauffeurDto;
import sn.kai.kaivoiture.service.ChauffeurImplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class ChauffeurController {
    ChauffeurImplement chauffeurImplement;
    @GetMapping("/chauffeurs")
    public Collection<ChauffeurDto> chauffeurs(){

        return chauffeurImplement.getAllChauffeur();

    }
    @GetMapping("/chauffeurs/{id}")
    public ChauffeurDto getChauffeur(@PathVariable(value = "id") int id){

        return chauffeurImplement.getChauffeur(id);

    }
    @PostMapping("/saveChauffeur")
    public ChauffeurDto ajoutChauffeur(@RequestBody ChauffeurDto chauffeurDto)  {

        return chauffeurImplement.addChauffeur(chauffeurDto);
    }
@GetMapping("/detaiChauffeur/{id}")
    public ChauffeurDto edite(@PathVariable(value = "id")int id) {
        return chauffeurImplement.getChauffeur(id);
    }
    @PutMapping("/updateChauffeur/{id}")
    public ChauffeurDto updatevehicule(@PathVariable(value = "id")int id,@RequestBody ChauffeurDto chauffeurDto){
        chauffeurDto.setId(id);
        return   chauffeurImplement.updateChauffeur(chauffeurDto);
    }
    @DeleteMapping("/suprimerChauffeur/{id}")
    public void suprsion(@PathVariable(value = "id") int id){
        chauffeurImplement.deleteChauffeur(id);
    }

}
