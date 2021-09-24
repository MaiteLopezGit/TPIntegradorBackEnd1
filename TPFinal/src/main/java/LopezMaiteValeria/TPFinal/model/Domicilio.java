package LopezMaiteValeria.TPFinal.model;

import javax.persistence.*;

@Entity
@Table (name = "domicilio")
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
}
