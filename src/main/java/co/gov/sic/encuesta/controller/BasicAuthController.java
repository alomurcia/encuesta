package co.gov.sic.encuesta.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.sic.encuesta.dto.AutenticacionDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/basicauth")
public class BasicAuthController {

    @GetMapping
    public AutenticacionDto basicauth() {
        return new AutenticacionDto("Usted se ha autenticado");
    }
}
