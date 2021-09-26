package LopezMaiteValeria.TPFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name = "pacientes")
@Getter
@Setter
@ToString
public class Paciente {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDateTime fechaIngreso;

    @OneToOne
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

    public Integer getId() {
        return this.id;
    }
}
