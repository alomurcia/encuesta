package co.gov.sic.encuesta.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.sic.encuesta.dto.EncuestaDto;
import co.gov.sic.encuesta.model.Encuesta;
import co.gov.sic.encuesta.model.Marca;
import co.gov.sic.encuesta.repository.EncuestaRepository;
import co.gov.sic.encuesta.repository.MarcaRepository;

@Service
public class EncuestaService {
    @Autowired
    private EncuestaRepository encuestaRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    public Iterable<EncuestaDto> findAll() {
        ArrayList<EncuestaDto> encuestas = new ArrayList<EncuestaDto>();
        this.encuestaRepository.findAll().forEach(encuesta -> {
            encuestas.add(
                    new EncuestaDto(encuesta.getId(), encuesta.getNumDocumento(), encuesta.getEmail(),
                            encuesta.getComentarios(),
                            encuesta.getMarca().getId(), encuesta.getFechaRespuesta()));
        });
        return encuestas;
    }

    public void registrar(EncuestaDto encuestaDto) {
        Encuesta encuesta = new Encuesta();
        encuesta.setNumDocumento(encuestaDto.getNumDocumento());
        encuesta.setEmail(encuestaDto.getEmail());
        encuesta.setComentarios(encuestaDto.getComentarios());
        encuesta.setFechaRespuesta(new Date());
        Optional<Marca> marca = this.marcaRepository.findById(encuestaDto.getIdMarca());
        if (!marca.isPresent()) {
            throw new IllegalArgumentException("marca no existe");
        }
        encuesta.setMarca(marca.get());
        this.encuestaRepository.save(encuesta);
        encuestaDto.setId(encuesta.getId());
    }

    public void eliminar(Long idEncuesta){
        this.encuestaRepository.deleteById(idEncuesta);
    }
}
