package br.edu.ifsc.fln.carwashapi.service;

import br.edu.ifsc.fln.carwashapi.dto.ClienteDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Cliente;
import br.edu.ifsc.fln.carwashapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente create(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente = toCliente(dto, cliente);
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente;
        }
        return null;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void update(int id,ClienteDTO dto) {
        try {
        clienteRepository.findById(id).ifPresent(cliente -> {
            cliente.setNome(dto.getNome());
            cliente.setEmail(dto.getEmail());
            cliente.setCelular(dto.getCelular());
            clienteRepository.save(cliente);
        });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    public Cliente toCliente(ClienteDTO dto, Cliente cliente){
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCelular(dto.getCelular());
        return cliente;
    }


}
