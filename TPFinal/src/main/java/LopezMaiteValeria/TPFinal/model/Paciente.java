package LopezMaiteValeria.TPFinal.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name = "pacientes")
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

    @OneToMany(mappedBy = "paciente_id")
    private Set<Turno> turnos;
}
