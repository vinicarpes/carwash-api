package br.edu.ifsc.fln.carwashapi.repository;

import br.edu.ifsc.fln.carwashapi.model.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
