package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
public class Odontologo {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo_id")
    private Set<Turno> turnos;
}
