package LopezMaiteValeria.TPFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Getter @Setter @ToString
public class Turno {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime fechaTurno;

    @ManyToOne
    @JoinColumn ( name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn( name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

}
