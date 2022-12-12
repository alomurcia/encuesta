package co.gov.sic.encuesta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.sic.encuesta.dto.MarcaDto;
import co.gov.sic.encuesta.repository.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Iterable<MarcaDto> findAll() {
        ArrayList<MarcaDto> marcas = new ArrayList<MarcaDto>();
        marcaRepository.findAll().forEach(marca -> {
            marcas.add(new MarcaDto(marca.getId(), marca.getNombre()));
        });
        return marcas;
    }
}
