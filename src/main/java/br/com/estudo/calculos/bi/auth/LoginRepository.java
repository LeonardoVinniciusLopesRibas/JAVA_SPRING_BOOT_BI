package br.com.estudo.calculos.bi.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String login);

}
