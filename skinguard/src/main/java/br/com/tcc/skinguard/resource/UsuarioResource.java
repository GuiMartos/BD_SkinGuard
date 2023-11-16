package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.UsuarioRepository;
import br.com.tcc.skinguard.repository.filter.UsuarioFilter;
import br.com.tcc.skinguard.repository.projections.ResumoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/todos")
    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll(Sort.by("login").ascending());
    }

    @GetMapping()
    public Page<ResumoUsuario> pesquisar(UsuarioFilter usuarioFilter, Pageable pageable){
        return usuarioRepository.filtrar(usuarioFilter, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id){usuarioRepository.deleteById(id);}

    @PutMapping("/mudar-usuario/{id}")
    public HttpStatus mudarusuario(@PathVariable Integer id, @RequestBody Usuario usuarioRequest){
        return usuarioRepository.findById(id).map(
                usuario -> {
                    usuario.setPele(usuarioRequest.getPele());
                    usuario.setFps(usuarioRequest.getFps());
                    usuario.setLogin(usuarioRequest.getLogin());
                    usuario.setSenha(usuarioRequest.getSenha());
                    return HttpStatus.OK;
                }
        ).orElseGet(() -> {
            return HttpStatus.NOT_FOUND;
        });
    }


}
