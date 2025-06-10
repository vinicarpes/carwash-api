package br.edu.ifsc.fln.carwashapi.service;

import br.edu.ifsc.fln.carwashapi.dto.ModeloDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Marca;
import br.edu.ifsc.fln.carwashapi.model.domain.Modelo;
import br.edu.ifsc.fln.carwashapi.repository.MarcaRepository;
import br.edu.ifsc.fln.carwashapi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository repository;
    @Autowired
    private MarcaRepository marcaRepository;
    public List<Modelo> listarModelos() {
        return repository.findAll();
    }

    public Modelo create(ModeloDTO dto) {
        Modelo modelo = new Modelo();
        Optional<Marca> marca = marcaRepository.findById(dto.getMarca_id());
        if (marca.isPresent()) {
            modelo.setMarca(marca.get());
        }
        modelo = toModelo(dto, modelo);
        return repository.save(modelo);
    }

    public void update(int id, ModeloDTO dto) {
        Optional<Modelo> modeloOptional = repository.findById(id);
        try{
            if (modeloOptional.isPresent()) {
                Modelo modelo = toModelo(dto, modeloOptional.get());
                modelo.setId(id);
                repository.save(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Modelo toModelo(ModeloDTO dto, Modelo modelo) {
        modelo.setDescricao(dto.getDescricao());
        modelo.getMotor().setPotencia(dto.getPotencia());
        modelo.getMotor().setTipoCombustivel(dto.getTipoCombustivel());
        return modelo;
    }

    public Optional<Modelo> findById(int modeloId) {
        Optional<Modelo> modeloOptional = repository.findById(modeloId);
        if (modeloOptional.isPresent()) {
            return modeloOptional;
        }
        else
            return Optional.empty();
    }
}
