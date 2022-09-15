package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.kai.kaivoiture.Entites.Vehicules;
import sn.kai.kaivoiture.enums.TypesCarburant;

@RepositoryRestResource()
public interface VehiculeRepository extends JpaRepository<Vehicules,Integer> {

long countVehiculesByEnmarcheIsTrue();
long countVehiculesByEnmarcheIsFalse();
long countVehiculesByEtatpanneIsFalse();
long countVehiculesByEtatpanneIsTrue();





}
