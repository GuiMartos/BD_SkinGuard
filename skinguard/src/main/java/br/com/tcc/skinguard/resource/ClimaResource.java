package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.ClimaRepository;
import br.com.tcc.skinguard.repository.FpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clima")
public class ClimaResource {

    @Autowired
    private ClimaRepository climaRepository;

    @GetMapping("/todos")
    public List<Clima> listarClima(){
        return climaRepository.findAll(Sort.by("clima").ascending());
    }

}
