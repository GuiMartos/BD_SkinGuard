package br.com.tcc.skinguard.repository;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.usuario.UsuarioRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, UsuarioRepositoryQuery {
}
