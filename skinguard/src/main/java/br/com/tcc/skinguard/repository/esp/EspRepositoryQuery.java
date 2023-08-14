package br.com.tcc.skinguard.repository.esp;

import br.com.tcc.skinguard.model.Esp;
import br.com.tcc.skinguard.repository.filter.EspFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EspRepositoryQuery  {
    Page<Esp> filtrar(EspFilter espFilter, Pageable pageable);
}
