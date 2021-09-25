package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Turno;
import LopezMaiteValeria.TPFinal.repository.ITurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements IService<Turno>{
    @Autowired
    ITurnoRepository turnoRepository;

    private final Logger logger = Logger.getLogger(TurnoService.class);

    @Override
    public Turno crear(Turno turno) {
        logger.debug("Iniciando el metodo crear()");
        Turno turnoCreado = null;
        try {
            turnoRepository.save(turno);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Finalizando el metodo crear()");
        return turnoCreado;
    }

    @Override
    public Turno buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar()");
        Turno turnoBuscado = null;
        try {
            if (turnoRepository.findById(id).isPresent())
                turnoBuscado = turnoRepository.findById(id).get();
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscar()");
        return turnoBuscado;
    }

    @Override
    public List<Turno> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Turno> turnos = new ArrayList<>();
        try {
            turnos = turnoRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscarTodos()");
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        logger.debug("Iniciando el metodo actualizar()");
        Turno turnoActualizado = null;

        try {
            if(turnoRepository.existsById(turno.getId()))
                turnoActualizado = turnoRepository.save(turno);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo actualizar()");
        return turnoActualizado;
    }

    @Override
    public void eliminar(Integer id) {
        logger.debug("Inciando el metodo eliminar()");
        try {
            turnoRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminado el metodo eliminar()");
    }
}
