package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Turno;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ITurnoService {
    void crearTurno(Turno turno);
    List<Turno> buscarTodos();
    Turno buscar(Integer id);
    void actualizar(Turno turno);
    void eliminar(Integer id);

}
