package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "domicilio")
@Getter
@Setter
public class Domicilio {

    @Id
    @GeneratedValue
    private Integer id;
    private String localidad;
    private String calle;
    private int numero;
    private String provincia;

    @OneToOne
    private Paciente paciente;

    public Integer getId() {
        return this.id;
    }
}
