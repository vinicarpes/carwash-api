package br.edu.ifsc.fln.carwashapi.repository;

import br.edu.ifsc.fln.carwashapi.model.domain.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
