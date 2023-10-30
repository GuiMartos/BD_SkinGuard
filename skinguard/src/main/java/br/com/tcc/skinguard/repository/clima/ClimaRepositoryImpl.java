package br.com.tcc.skinguard.repository.clima;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.repository.filter.ClimaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

public class ClimaRepositoryImpl implements ClimaRepositoryQuery {

    private EntityManager manager;
    @Override
    public Page<Clima> filtrar(ClimaFilter climaFilter, Pageable pageable) {
        return null;
    }
}
