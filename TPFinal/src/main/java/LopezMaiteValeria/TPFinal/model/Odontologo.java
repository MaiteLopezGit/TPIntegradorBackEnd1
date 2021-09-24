package LopezMaiteValeria.TPFinal.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
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
