package br.edu.ifsc.fln.carwashapi.dto;

import br.edu.ifsc.fln.carwashapi.model.domain.Marca;
import br.edu.ifsc.fln.carwashapi.model.enums.ETipoCombustivel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
public class ModeloDTO {
    private String descricao;
    private int marca_id;
    private int potencia;
    private ETipoCombustivel tipoCombustivel;
}
