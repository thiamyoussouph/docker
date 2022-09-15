package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.kai.kaivoiture.Dtos.ModeleDto;
import sn.kai.kaivoiture.Entites.Marque;
import sn.kai.kaivoiture.Entites.Modele;
import sn.kai.kaivoiture.service.ModelIplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ModelController {
private ModelIplement modelIplement;
    @GetMapping("/affiche/modele")
    public Collection<ModeleDto> modele(){

        return modelIplement.ListeModele();

    }
}
