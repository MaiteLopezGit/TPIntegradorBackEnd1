package LopezMaiteValeria.TPFinal.model.DTO;

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

}