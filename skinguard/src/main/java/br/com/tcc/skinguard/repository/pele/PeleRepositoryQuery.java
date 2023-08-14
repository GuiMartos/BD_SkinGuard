package br.com.tcc.skinguard.repository.pele;

import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.filter.PeleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeleRepositoryQuery {
    Page<Pele> filtar(PeleFilter peleFilter, Pageable pageable);
}
