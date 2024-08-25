package br.com.estudo.calculos.bi.repository;

import br.com.estudo.calculos.bi.model.Switches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitchesRepository extends JpaRepository<Switches, Integer> {
}
