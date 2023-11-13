package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.repository.clima.ClimaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<Clima, Integer>, ClimaRepositoryQuery {
}