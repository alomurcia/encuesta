package co.gov.sic.encuesta.repository;

import org.springframework.data.repository.CrudRepository;

import co.gov.sic.encuesta.model.Encuesta;

public interface EncuestaRepository extends CrudRepository<Encuesta, Long> {

}
