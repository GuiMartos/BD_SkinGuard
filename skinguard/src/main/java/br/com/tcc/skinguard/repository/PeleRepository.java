package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.pele.PeleRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeleRepository extends JpaRepository<Pele, Integer>, PeleRepositoryQuery {
}
