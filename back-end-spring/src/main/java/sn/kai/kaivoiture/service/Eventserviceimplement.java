package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.*;
import sn.kai.kaivoiture.Repository.*;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class Eventserviceimplement implements Ievent {
    @Autowired
    private EVentRepository eVentRepository;
    @Autowired
    private PAnnesRepository pAnnesRepository;
    @Autowired
private AccidenrRepository accidenrRepository;
    @Autowired
private JobRepository jobRepository;
    @Autowired
    private IncidentRepository incidentRepository;
    @Override
    public Panne savpane(Panne panne) {

        return pAnnesRepository.save(panne);
    }


    @Override
    public Accident saveAccident(Accident accident) {

        return accidenrRepository.save(accident);
    }

    @Override
    public Jobs saveJOb(Jobs jobs) {

        return jobRepository.save(jobs);
    }

    @Override
    public Collection<Jobs> getJObs() {
        return jobRepository.findAll();
    }

    @Override
    public Collection<Accident> getaccidents() {
        return accidenrRepository.findAll();
    }

    @Override
    public Collection<Panne> getpannes() {
        return pAnnesRepository.findAll();
    }

    @Override
    public void deletePanne(int id) {
        pAnnesRepository.deleteById(id);
    }

    @Override
    public void deletejobe(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void deleteAccident(int id) {
        accidenrRepository.deleteById(id);

    }

    @Override
    public Panne editPanne(int id) {
        return pAnnesRepository.findById(id).get();
    }

    @Override
    public Accident editAccident(int id) {

            return accidenrRepository.findById(id).get();
    }

    @Override
    public Accident updateAccident(Accident accident) {
        return accidenrRepository.save(accident);
    }

    @Override
    public Panne updatePanne(Panne panne) {
        return pAnnesRepository.save(panne);
    }

    @Override
    public Jobs updateJob(Jobs jobs) {
        return jobRepository.save(jobs);
    }

    @Override
    public Jobs editJob(int id) {
        return jobRepository.findById(id).get();
    }


    @Override
    public Collection<Event> getAll() {
        return eVentRepository.findAll();
    }

}
