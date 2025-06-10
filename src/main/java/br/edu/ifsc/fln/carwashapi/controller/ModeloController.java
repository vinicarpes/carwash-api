package br.edu.ifsc.fln.carwashapi.controller;

import br.edu.ifsc.fln.carwashapi.dto.ModeloDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Modelo;
import br.edu.ifsc.fln.carwashapi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsc.fln.carwashapi.service.ModeloService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;

    private ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService=modeloService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Modelo> create(@RequestBody ModeloDTO modelo) {
        return ResponseEntity.ok().body(modeloService.create(modelo));
    }
    @GetMapping()
    public ResponseEntity<List<Modelo>> get() {
        return ResponseEntity.ok(modeloRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> get(@PathVariable int id){
        Optional<Modelo> modelo = modeloRepository.findById(id);
        if(modelo.isPresent()){
            return ResponseEntity.ok(modelo.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ModeloDTO modelo) {
        try{
            modeloService.update(id, modelo);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Modelo> delete(@PathVariable Integer id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        if(modelo.isPresent()){
            modeloRepository.deleteById(id);
            return ResponseEntity.ok(modelo.get());
        }
        return ResponseEntity.notFound().build();
    }
}
