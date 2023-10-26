package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/todos")
    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll(Sort.by("usuario").ascending());
    }
}
