package br.com.tcc.skinguard.repository.usuario;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.filter.UsuarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRepositoryQuery {
    Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);
}
