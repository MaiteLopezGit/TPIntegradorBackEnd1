package LopezMaiteValeria.TPFinal.service;
import LopezMaiteValeria.TPFinal.model.Paciente;
import LopezMaiteValeria.TPFinal.model.PacienteDTO;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IPacienteService {

    void crear(PacienteDTO t);
    PacienteDTO buscar(Integer id);
    Set<PacienteDTO> buscarTodos();
    void actualizar(PacienteDTO t);
    void eliminar(Integer id);
    Set<PacienteDTO> buscarPacientesConApellidoLike(String apellido);


}
