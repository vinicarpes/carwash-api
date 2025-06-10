package br.edu.ifsc.fln.carwashapi.controller;

import br.edu.ifsc.fln.carwashapi.dto.VeiculoDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Veiculo;
import br.edu.ifsc.fln.carwashapi.repository.VeiculoRepository;
import br.edu.ifsc.fln.carwashapi.service.VeiculoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService  veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> get(@PathVariable int id) {
        Optional<Veiculo> veiculo = veiculoService.findById(id);
        if (veiculo.isPresent()) {
            return ResponseEntity.ok(veiculo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody VeiculoDTO dto) {
        try {
            Veiculo veiculoCriado = veiculoService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCriado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable int id, @RequestBody VeiculoDTO dto) {
        return ResponseEntity.ok(veiculoService.update(dto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
