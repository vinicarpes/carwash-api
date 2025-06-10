package br.edu.ifsc.fln.carwashapi.controller;

import br.edu.ifsc.fln.carwashapi.model.domain.Cor;
import br.edu.ifsc.fln.carwashapi.service.CorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cores")
public class CorController {
    private CorService corService;

    public CorController(CorService corService) {
        this.corService = corService;
    }

    @PostMapping
    public ResponseEntity<Cor> create(@RequestBody Cor cor){
        return ResponseEntity.status(HttpStatus.CREATED).body(corService.create(cor));
    }

    @GetMapping
    public ResponseEntity<List<Cor>> getAll(){
        return ResponseEntity.ok(corService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cor> update(@PathVariable Integer id, @RequestBody Cor cor){
        return ResponseEntity.ok(corService.update(id,cor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        return ResponseEntity.ok().build();
    }
}