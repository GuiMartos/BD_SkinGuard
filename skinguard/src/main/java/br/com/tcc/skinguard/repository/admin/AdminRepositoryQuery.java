package br.com.tcc.skinguard.repository.admin;

import br.com.tcc.skinguard.model.Admin;
import br.com.tcc.skinguard.repository.filter.AdminFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminRepositoryQuery {

    public Page<Admin> filtrar(AdminFilter adminFilter, Pageable pageable);

}
