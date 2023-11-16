package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.repository.ClimaRepository;
import br.com.tcc.skinguard.repository.filter.ClimaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clima")
public class ClimaResource {

    @Autowired
    private ClimaRepository climaRepository;

    @GetMapping("/todos")
    public List<Clima> listarClima(){
        return climaRepository.findAll(Sort.by("hora").ascending());
    }

   @GetMapping()
   public Page<Clima> pesquisar(ClimaFilter climaFilter, Pageable pageable){
        return climaRepository.filtrar(climaFilter, pageable);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id){climaRepository.deleteById(id);}

    @PutMapping("/mudar-clima/{id}")
    public HttpStatus mudarclima(@PathVariable Integer id, @RequestBody Clima climaRequest){
        return climaRepository.findById(id).map(
                clima -> {
                    clima.setHora(climaRequest.getHora());
                    clima.setDia(climaRequest.getDia());
                    clima.setUvindex(climaRequest.getUvindex());
                    clima.setSol1(climaRequest.getSol1());
                    clima.setSol2(climaRequest.getSol2());
                    return  HttpStatus.OK;
                }
        ).orElseGet(() -> {
            return HttpStatus.NOT_FOUND;
        });
    }

    @PostMapping()
    public ResponseEntity<Clima> criar(@RequestBody Clima clima){
        return new ResponseEntity<>(climaRepository.save(clima),HttpStatus.CREATED);
    }
}
