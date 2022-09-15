package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;


import sn.kai.kaivoiture.Dtos.TypesPannesDto;

import sn.kai.kaivoiture.service.TypesPannesIplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class TypesPanneController {

private TypesPannesIplement typesPannesIplement;
    @PostMapping("/savepanne")
    public TypesPannesDto savepanes(@RequestBody TypesPannesDto typespannesDto){
        return typesPannesIplement.savepanne(typespannesDto);
    }
    @GetMapping("/Pannes")
    public Collection<TypesPannesDto> panes(){

        return typesPannesIplement.listPanne();

    }
    @GetMapping("editePanne/{id}")
    public TypesPannesDto edite(@PathVariable(value = "id")int id)  {
        return typesPannesIplement.findbyid(id);
    }
    @DeleteMapping("/suprimerPannes/{id}")
    public void suprsion(@PathVariable(value = "id") int id){typesPannesIplement.delete(id);
    }
    @PutMapping("/updatepannes/{id}")
    public TypesPannesDto updatevehicule(@PathVariable(value = "id")int id,@RequestBody TypesPannesDto typespannesDto) {
        typespannesDto.setId(id);
        return typesPannesIplement.update(typespannesDto);
    }

}
