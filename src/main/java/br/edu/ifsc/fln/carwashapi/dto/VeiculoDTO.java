package br.edu.ifsc.fln.carwashapi.dto;

import lombok.Getter;

@Getter
public class VeiculoDTO {
    private String placa;
    private int modelo_id;
    private int cor_id;
    private int cliente_id;
    private String observacao;
}
