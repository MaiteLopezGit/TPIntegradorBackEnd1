package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "Turnos")
@Getter
@Setter
public class Turno {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime fechaTurno;

    @ManyToOne
    @JoinColumn( name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn( name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    public Integer getId() {
        return this.id;
    }
}


