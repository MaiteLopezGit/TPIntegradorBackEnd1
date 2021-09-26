package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Turno;

import java.util.Collection;
import java.util.List;

public interface ITurnoService {
    public void crearTurno(Turno turno);

    public List<Turno> buscarTodos();
}
