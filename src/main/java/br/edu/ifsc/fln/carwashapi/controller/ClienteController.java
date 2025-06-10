package br.edu.ifsc.fln.carwashapi.controller;

import br.edu.ifsc.fln.carwashapi.dto.ClienteDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Cliente;
import br.edu.ifsc.fln.carwashapi.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> get() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping()
    public ResponseEntity<Cliente> create(@RequestBody ClienteDTO cliente) {
        try{
            Cliente clienteCreated = clienteService.create(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreated);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody ClienteDTO cliente) {
        clienteService.update(id, cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
