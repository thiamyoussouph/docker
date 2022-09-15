package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.kai.kaivoiture.Entites.Marque;
@RepositoryRestResource()
public interface MarqueReposirory extends JpaRepository<Marque,Integer> {
}
