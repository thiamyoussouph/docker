package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.KilometrageVehicule;

public interface KilometrageRepository extends JpaRepository<KilometrageVehicule,Integer> {
}
