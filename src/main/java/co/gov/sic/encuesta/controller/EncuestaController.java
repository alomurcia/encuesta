package co.gov.sic.encuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.sic.encuesta.dto.EncuestaDto;
import co.gov.sic.encuesta.service.EncuestaService;

@RestController
@RequestMapping("encuesta")
@CrossOrigin(origins = "*")
public class EncuestaController {
    @Autowired
    private EncuestaService encuestaService;

    @GetMapping
    public ResponseEntity<Iterable<EncuestaDto>> getEncuestas() {
        return new ResponseEntity<Iterable<EncuestaDto>>(this.encuestaService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EncuestaDto> registrar(@RequestBody EncuestaDto encuestaDto) {
        this.encuestaService.registrar(encuestaDto);
        return new ResponseEntity<EncuestaDto>(encuestaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        this.encuestaService.eliminar(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
