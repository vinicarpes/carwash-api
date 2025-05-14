package br.edu.ifsc.fln.carwashapi.repository;

import br.edu.ifsc.fln.carwashapi.model.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
