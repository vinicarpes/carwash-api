package br.edu.ifsc.fln.carwashapi.model.domain;

import br.edu.ifsc.fln.carwashapi.model.enums.ECategoria;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private double valor;
    private ECategoria categoria;
}
