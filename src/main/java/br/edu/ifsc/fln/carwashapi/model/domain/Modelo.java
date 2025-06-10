package br.edu.ifsc.fln.carwashapi.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    @Embedded
    private Motor motor = new Motor();
}
