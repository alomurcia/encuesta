package co.gov.sic.encuesta.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EncuestaDto {
    private Long id;
    private Long numDocumento;
    private String email;
    private String comentarios;
    private Long idMarca;
    private Date fechaRespuesta;
}
