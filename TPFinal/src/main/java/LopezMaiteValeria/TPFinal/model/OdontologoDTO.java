package LopezMaiteValeria.TPFinal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OdontologoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    public Integer getId() {
        return this.id;
    }
}
