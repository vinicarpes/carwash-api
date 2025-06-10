package br.edu.ifsc.fln.carwashapi.repository;

import br.edu.ifsc.fln.carwashapi.model.domain.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CorRepository extends JpaRepository<Cor, Integer> {
}
