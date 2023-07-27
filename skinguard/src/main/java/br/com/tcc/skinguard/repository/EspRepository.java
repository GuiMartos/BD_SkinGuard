package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Esp;
import br.com.tcc.skinguard.repository.esp.EspRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspRepository extends JpaRepository<Esp, Integer>, EspRepositoryQuery {
}
