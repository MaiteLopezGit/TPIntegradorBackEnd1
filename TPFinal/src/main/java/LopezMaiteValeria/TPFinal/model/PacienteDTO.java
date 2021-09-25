package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDateTime fechaIngreso;

}
