package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.kai.kaivoiture.Entites.TypesPannes;

public interface TypesPanneRepository extends JpaRepository<TypesPannes,Integer> {
}
