package br.edu.ifsc.fln.carwashapi.model.domain;

import br.edu.ifsc.fln.carwashapi.model.enums.ETipoCombustivel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Motor {
    private int potencia;
    private ETipoCombustivel tipoCombustivel;
}
