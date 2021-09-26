package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.Turno;
import LopezMaiteValeria.TPFinal.repository.ITurnoRepository;
import LopezMaiteValeria.TPFinal.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    ITurnoRepository turnoRepository;

    @Override
    public void crearTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public List<Turno> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnos;
    }

    @Override
    public Turno buscar(Integer id) {
        return turnoRepository.findById(id).get(); //Find devuelve un Optional, con get obtengo el turno
    }

    @Override
    public void actualizar(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }
}
