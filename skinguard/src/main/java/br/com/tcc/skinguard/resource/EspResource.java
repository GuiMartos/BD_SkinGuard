package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Esp;
import br.com.tcc.skinguard.repository.EspRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/esp")
public class EspResource {

    @Autowired
    private EspRepository espRepository;

    @GetMapping("/todos")
    public List<Esp> listarTodosEsp(){
        return espRepository.findAll(Sort.by("esp").ascending());
    }
}
