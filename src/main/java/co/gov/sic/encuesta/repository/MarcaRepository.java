package co.gov.sic.encuesta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.gov.sic.encuesta.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> {

}
