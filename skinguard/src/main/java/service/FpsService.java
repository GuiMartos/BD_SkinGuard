package service;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.ClimaRepository;
import br.com.tcc.skinguard.repository.FpsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FpsService {

    @Autowired
    private FpsRepository fpsRepository;

    public Fps salvar(Fps fps){
        return fpsRepository.save(fps);
    }

    public Fps atualizar(Integer id, Fps fps){
        Fps fpsaSalva = buscarFpsEsistente(id);
        return fpsRepository.save(fpsaSalva);
    }

    private Fps buscarFpsEsistente(Integer id){
        Optional<Fps> fpsSalva = fpsRepository.findById(id);
        if (!fpsSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return fpsSalva.get();
    }
}
