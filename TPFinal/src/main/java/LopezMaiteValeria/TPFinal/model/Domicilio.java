package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "domicilios")
@Getter
@Setter
@ToString
public class Domicilio {

    @Id
    @GeneratedValue
    private Integer id;
    private String localidad;
    private String calle;
    private int numero;
    private String provincia;

    public Integer getId() {
        return this.id;
    }
}
