package LopezMaiteValeria.TPFinal.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class DomicilioDTO {

    private Integer id;
    private String localidad;
    private String calle;
    private int numero;
    private String provincia;

}
