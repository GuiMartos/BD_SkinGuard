package br.com.tcc.skinguard.repository.fps;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.filter.FpsFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FpsRepositoryQuery {

    Page<Fps> filtrar(FpsFilter fpsFilter, Pageable pageable);
}
