package br.com.tcc.skinguard.repository.clima;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.repository.filter.ClimaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClimaRepositoryQuery {

    Page<Clima> filtrar(ClimaFilter climaFilter, Pageable pageable);
}
