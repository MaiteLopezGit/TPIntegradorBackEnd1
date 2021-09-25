package LopezMaiteValeria.TPFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name = "pacientes")
@Getter
@Setter
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
    @JsonIgnore //Esta anotacion se acrega porque el mapper sino entra en un ciclo infinito
    //Al buscar los metodos y atributos de Paciente que tiene turnos y cuando va a turnos tiene Pacientes...
    private Set<Turno> turnos;

    public Integer getId() {
        return this.id;
    }
}
