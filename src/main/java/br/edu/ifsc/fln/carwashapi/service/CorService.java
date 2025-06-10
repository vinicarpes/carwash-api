package br.edu.ifsc.fln.carwashapi.service;

import br.edu.ifsc.fln.carwashapi.model.domain.Cor;
import br.edu.ifsc.fln.carwashapi.repository.CorRepository;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

@Service
public class CorService {
    private CorRepository repository;

    public CorService(CorRepository repository) {
        this.repository = repository;
    }

    public List<Cor> getAll () {
        return repository.findAll();
    }

    public Cor create (Cor cor) {
        return repository.save(cor);
    }

    public Cor update (int id,Cor cor) {
        Optional<Cor> c = repository.findById(id);
        if(c.isPresent()) {
            cor.setId(id);
            return repository.save(cor);
        }
        return c.get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
