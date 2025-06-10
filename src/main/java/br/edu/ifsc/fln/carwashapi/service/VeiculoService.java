package br.edu.ifsc.fln.carwashapi.service;

import br.edu.ifsc.fln.carwashapi.dto.VeiculoDTO;
import br.edu.ifsc.fln.carwashapi.model.domain.Cliente;
import br.edu.ifsc.fln.carwashapi.model.domain.Cor;
import br.edu.ifsc.fln.carwashapi.model.domain.Modelo;
import br.edu.ifsc.fln.carwashapi.model.domain.Veiculo;
import br.edu.ifsc.fln.carwashapi.repository.ClienteRepository;
import br.edu.ifsc.fln.carwashapi.repository.CorRepository;
import br.edu.ifsc.fln.carwashapi.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final ModeloService modeloService;
    private VeiculoRepository veiculoRepository;
    private ClienteService clienteService;
    private CorRepository corRepository;

    public VeiculoService(VeiculoRepository veiculoRepository,
                          ClienteService clienteService,
                          CorRepository corRepository, ModeloService modeloService) {
        this.veiculoRepository = veiculoRepository;
        this.clienteService = clienteService;
        this.corRepository = corRepository;
        this.modeloService = modeloService;
    }

    public List<Veiculo> getAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo create (VeiculoDTO dto){
        Veiculo veiculo = new Veiculo();
        veiculo = toVeiculo(dto, veiculo);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(VeiculoDTO dto, int id){
        Veiculo veiculo = veiculoRepository.findById(id).get();
        veiculo = toVeiculo(dto, veiculo);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo toVeiculo(VeiculoDTO dto, Veiculo veiculo){
        veiculo.setCliente(getCliente(dto.getCliente_id()).get());
        veiculo.setCor(getCor(dto.getCor_id()).get());
        veiculo.setModelo(getModelo(dto.getModelo_id()).get());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setObservacao(dto.getObservacao());
        return veiculo;
    }

    public Optional<Cliente> getCliente(int cliente_id){
        return clienteService.findById(cliente_id);
    }

    public Optional<Cor> getCor(int cor_id){
        return corRepository.findById(cor_id);
    }

    public Optional<Modelo> getModelo(int modelo_id){
        return modeloService.findById(modelo_id);
    }


    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(int id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        return veiculo;
    }

    public void delete(int id) {
        veiculoRepository.deleteById(id);
    }
}
