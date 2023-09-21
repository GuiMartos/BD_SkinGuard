package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.FpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
