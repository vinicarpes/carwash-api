package br.edu.ifsc.fln.carwashapi.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Cor {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
}
