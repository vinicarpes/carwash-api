package br.edu.ifsc.fln.carwashapi.controller;

import br.edu.ifsc.fln.carwashapi.domain.Marca;
import br.edu.ifsc.fln.carwashapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Marca marca){
        marcaRepository.save(marca);
    }

    @GetMapping()
    public List<Marca> get(){
        return marcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> get(@PathVariable Long id){
        Optional<Marca> marca = marcaRepository.findById(id);
        if (marca.isPresent()) {
            return ResponseEntity.ok(marca.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
