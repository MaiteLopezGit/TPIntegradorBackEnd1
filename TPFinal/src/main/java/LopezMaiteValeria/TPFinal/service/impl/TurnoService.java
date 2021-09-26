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
}
