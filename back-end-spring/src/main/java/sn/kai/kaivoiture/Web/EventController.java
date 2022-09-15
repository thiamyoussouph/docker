package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Dtos.VehiculesDto;
import sn.kai.kaivoiture.Entites.Accident;
import sn.kai.kaivoiture.Entites.Event;
import sn.kai.kaivoiture.Entites.Jobs;
import sn.kai.kaivoiture.Entites.Panne;
import sn.kai.kaivoiture.Exception.VehiculeExceptionEdite;
import sn.kai.kaivoiture.service.Eventserviceimplement;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EventController {
    @Autowired
    private Eventserviceimplement eventserviceimplement;

    @GetMapping("/events")
    public Collection<Event>getevents(){
        return eventserviceimplement.getAll();

    }
    @PostMapping("/savepane")
    public Panne savepane( @RequestBody Panne panne){
        return eventserviceimplement.savpane(panne);
    }

    @PostMapping("/saveaccident")
    public Accident saveacident(@RequestBody Accident accident){
        return eventserviceimplement.saveAccident(accident);
    }
    @PostMapping("/savejob")
    public Jobs savejobs(@RequestBody Jobs  jobs){
        return eventserviceimplement.saveJOb(jobs);
    }
    @GetMapping("/getjobs")
    public Collection<Jobs> Jobs(){

        return eventserviceimplement.getJObs();

    }
    @GetMapping("/getaccidents")
    public Collection<Accident> acident(){

        return eventserviceimplement.getaccidents();

    }
    @GetMapping("/getPan")
    public Collection<Panne> getPan(){

        return eventserviceimplement.getpannes();

    }
    @DeleteMapping("/deletepanne/{id}")
    public void deletePanne(@PathVariable int id){
        eventserviceimplement.deletePanne(id);
    }
    @DeleteMapping("/deletejob/{id}")
    public void deletejob(@PathVariable int id){
        eventserviceimplement.deletejobe(id);
    }
    @DeleteMapping("/deleteaccident/{id}")
    public void deleteaccident(@PathVariable int id){
        eventserviceimplement.deleteAccident(id);
    }
    @GetMapping("/editerpanne/{id}")
    public Panne edite(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
        return  eventserviceimplement.editPanne(id);
    }
    @GetMapping("/editeracident/{id}")
    public Accident editeaccident(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
        return  eventserviceimplement.editAccident(id);
    }
    @PutMapping("/updateaccident/{id}")
    public Accident updateAccident(@PathVariable(value = "id")int id,@RequestBody Accident accident) throws VehiculeExceptionEdite {
        accident.setId(id);
        return eventserviceimplement.updateAccident(accident);
    }
    @PutMapping("/updatepanne/{id}")
    public Panne updatepanne(@PathVariable(value = "id")int id,@RequestBody Panne panne) throws VehiculeExceptionEdite {
        panne.setId(id);
        return eventserviceimplement.updatePanne(panne);
    }
    @PutMapping("/updatejob/{id}")
    public Jobs updatejob(@PathVariable(value = "id")int id,@RequestBody Jobs jobs) throws VehiculeExceptionEdite {
        jobs.setId(id);
        return eventserviceimplement.updateJob(jobs);
    }
     @GetMapping("/editerjob/{id}")
    public Jobs editejob(@PathVariable(value = "id")int id) throws VehiculeExceptionEdite {
        return  eventserviceimplement.editJob(id);
     }


}
