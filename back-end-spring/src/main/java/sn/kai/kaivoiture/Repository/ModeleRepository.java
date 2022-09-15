package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.kai.kaivoiture.Entites.Modele;
@RepositoryRestResource()
public interface ModeleRepository extends JpaRepository<Modele,Integer> {
}
