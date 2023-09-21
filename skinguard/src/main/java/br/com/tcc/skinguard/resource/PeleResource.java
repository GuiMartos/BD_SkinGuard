package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.PeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pele")
public class PeleResource {

    @Autowired
    private PeleRepository peleRepository;

    @GetMapping("/todos")
    public List<Pele> listarTodosPele(){
        return peleRepository.findAll(Sort.by("pele").ascending());
    }
}
