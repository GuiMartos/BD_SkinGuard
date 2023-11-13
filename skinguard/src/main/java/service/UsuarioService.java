package service;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario usuario){
        Usuario usuarioSalva = buscarUsuarioEsistente(id);
        return usuarioRepository.save(usuarioSalva);
    }

    private Usuario buscarUsuarioEsistente(Integer id){
        Optional<Usuario> usurioSalva=usuarioRepository.findById(id);
        if (!usurioSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return usurioSalva.get();
    }
}
