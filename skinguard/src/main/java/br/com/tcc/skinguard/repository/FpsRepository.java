package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.fps.FpsRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FpsRepository extends JpaRepository<Fps, Integer>, FpsRepositoryQuery {
}
