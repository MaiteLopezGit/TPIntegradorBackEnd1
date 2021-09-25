package LopezMaiteValeria.TPFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
@ToString
public class Odontologo {


    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo_id")
    @JsonIgnore
    private Set<Turno> turnos;

    public Integer getId() {
        return this.id;
    }
}
