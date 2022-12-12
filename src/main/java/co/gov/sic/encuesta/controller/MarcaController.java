package co.gov.sic.encuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.sic.encuesta.dto.MarcaDto;
import co.gov.sic.encuesta.service.MarcaService;

@RestController()
@RequestMapping("marca")
@CrossOrigin(origins = "*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping()
    public ResponseEntity<Iterable<MarcaDto>> getMarcas() {
        return new ResponseEntity<Iterable<MarcaDto>>(marcaService.findAll(), HttpStatus.OK);
    }
}
