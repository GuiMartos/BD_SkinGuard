package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Admin;
import br.com.tcc.skinguard.repository.admin.AdminRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer>, AdminRepositoryQuery {
}
