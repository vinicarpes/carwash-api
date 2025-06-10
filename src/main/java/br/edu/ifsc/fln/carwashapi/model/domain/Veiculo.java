package br.edu.ifsc.fln.carwashapi.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("veiculos")
    private Cliente cliente;
    private String observacao;

}
