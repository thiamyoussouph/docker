package sn.kai.kaivoiture.service;

import sn.kai.kaivoiture.Entites.*;

import java.util.Collection;

public interface Ievent {

    Panne savpane(Panne panne);

    Accident saveAccident(Accident accident);
   Jobs saveJOb(Jobs jobs);
   Collection<Jobs> getJObs();
    Collection<Accident> getaccidents();
    Collection<Panne> getpannes();
    void deletePanne(int id);
    void deletejobe(int id);
    void deleteAccident(int id);
    Panne editPanne(int id);
    Accident editAccident(int id);
    Accident updateAccident(Accident accident);
    Panne updatePanne(Panne panne);
    Jobs updateJob(Jobs jobs);
    Jobs editJob(int id);






    Collection<Event> getAll();


}
