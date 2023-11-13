package service;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.repository.ClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClimaService {
    @Autowired
    private ClimaRepository climaRepository;

    public Clima salvar(Clima clima){
        return climaRepository.save(clima);
    }

    public Clima atualizar(Integer id, Clima clima){
        Clima climaSalva = buscarClimaEsistente(id);
        return climaRepository.save(climaSalva);
    }

    private Clima buscarClimaEsistente(Integer id){
        Optional<Clima> climaSalva = climaRepository.findById(id);
        if (!climaSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return climaSalva.get();
    }
}
