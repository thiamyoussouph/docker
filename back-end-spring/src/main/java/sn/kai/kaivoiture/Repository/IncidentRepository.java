package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.Incident;

public interface IncidentRepository extends JpaRepository<Incident,Integer> {


}
