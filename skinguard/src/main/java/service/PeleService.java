package service;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.ClimaRepository;
import br.com.tcc.skinguard.repository.PeleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PeleService {

    @Autowired
    private PeleRepository peleRepository;

    public Pele salvar(Pele pele){
        return peleRepository.save(pele);
    }

    public Pele atualizar(Integer id, Pele pele){
        Pele peleSalva = buscarPeleEsistente(id);
        return peleRepository.save(peleSalva);
    }

    private Pele buscarPeleEsistente(Integer id){
        Optional<Pele> peleSalva = peleRepository.findById(id);
        if (!peleSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return peleSalva.get();
    }
}
