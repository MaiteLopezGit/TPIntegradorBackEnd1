package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class TurnoDTO {

    private Integer id;
    private LocalDateTime fechaTurno;
    private Paciente paciente;
    private Odontologo odontologo;

}
