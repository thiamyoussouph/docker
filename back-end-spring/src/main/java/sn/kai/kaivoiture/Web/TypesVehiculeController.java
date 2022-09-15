package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.kai.kaivoiture.Dtos.TypesVehiculesDto;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.Entites.TypesVehicules;
import sn.kai.kaivoiture.service.TypesVehiculeImplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class TypesVehiculeController {
    private TypesVehiculeImplement typesVehiculeImplement;
    @GetMapping("/affiche/typesvehicule")
    public Collection<TypesVehiculesDto> typesVehicule(){

        return typesVehiculeImplement.ListetypesVehicule();

    }
}
