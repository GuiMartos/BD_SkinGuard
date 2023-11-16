package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.FpsRepository;
import br.com.tcc.skinguard.repository.filter.FpsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fps")
public class FpsResource {

    @Autowired
    private FpsRepository fpsRepository;

    @GetMapping("/todos")
    public List<Fps> listarTodosFps(){
        return fpsRepository.findAll(Sort.by("fps").ascending());
    }

    @GetMapping()
    public Page<Fps> pesquisar(FpsFilter fpsFilter, Pageable pageable){
        return fpsRepository.filtrar(fpsFilter, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id){fpsRepository.deleteById(id);}

    @PutMapping("/mudar-fps/{id}")
    public HttpStatus mudarfps(@PathVariable Integer id, @RequestBody Fps fpsRequest){
        return fpsRepository.findById(id).map(
                fps -> {
                    fps.setFps(fpsRequest.getFps());
                    fps.setUsuariofps(fpsRequest.getUsuariofps());
                    return HttpStatus.OK;

                }
        ) .orElseGet(() -> {
            return HttpStatus.NOT_FOUND;
        });
    }

    @PostMapping()
    public ResponseEntity<Fps> criar(@RequestBody Fps fps){
        return new ResponseEntity<>(fpsRepository.save(fps),HttpStatus.CREATED);
    }

}
