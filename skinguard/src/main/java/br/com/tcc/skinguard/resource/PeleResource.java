package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.PeleRepository;
import br.com.tcc.skinguard.repository.filter.PeleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pele")
public class PeleResource {

    @Autowired
    private PeleRepository peleRepository;

    @GetMapping("/todos")
    public List<Pele> listarTodosPele(){
        return peleRepository.findAll(Sort.by("tom").ascending());
    }

    @GetMapping()
    public Page<Pele> pesquisar(PeleFilter peleFilter, Pageable pageable){
        return peleRepository.filtar(peleFilter, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id){peleRepository.deleteById(id);}

    @PutMapping("/mudar-pele/{id}")
    public HttpStatus mudarfps(@PathVariable Integer id, @RequestBody Pele peleRequest){
        return peleRepository.findById(id).map(
                pele -> {
                    pele.setTom(peleRequest.getTom());
                    pele.setUsuariopele(peleRequest.getUsuariopele());
                    return HttpStatus.OK;
                }
        ).orElseGet(() -> {
            return HttpStatus.NOT_FOUND;
        });
    }

    @PostMapping()
    public ResponseEntity<Pele> criar(@RequestBody Pele pele){
        return new ResponseEntity<>(peleRepository.save(pele),HttpStatus.CREATED);
    }

}
