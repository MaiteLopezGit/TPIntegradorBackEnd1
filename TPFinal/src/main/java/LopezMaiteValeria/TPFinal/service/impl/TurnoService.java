package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.DTO.TurnoDTO;
import LopezMaiteValeria.TPFinal.model.Turno;
import LopezMaiteValeria.TPFinal.repository.ITurnoRepository;
import LopezMaiteValeria.TPFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements IService<TurnoDTO> {
    @Autowired
    ITurnoRepository turnoRepository;

    private final Logger logger = Logger.getLogger(TurnoService.class);
    private ObjectMapper mapper;

    @Override
    public void crear(TurnoDTO turnoDTO) {
        logger.debug("Iniciando el metodo crear()");
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

        try {
            turnoRepository.save(turno);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Finalizando el metodo crear()");
    }

    @Override
    public TurnoDTO buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar()");
        Turno turno = null;
        TurnoDTO turnoDTO = null;

        try {
            if (turnoRepository.findById(id).isPresent())
                turno = turnoRepository.findById(id).get();
                turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscar()");
        return turnoDTO;
    }

    @Override
    public Collection<TurnoDTO> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Turno> turnos = new ArrayList<>();
        Set<TurnoDTO> turnosDto = new HashSet<>();

        try {
            turnos = turnoRepository.findAll();
            for (Turno turno: turnos){
                turnosDto.add(mapper.convertValue(turno, TurnoDTO.class));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscarTodos()");
        return turnosDto;
    }

    @Override
    public void actualizar(TurnoDTO turnoDTO) {
        logger.debug("Iniciando el metodo actualizar()");
        Turno turno = null;

        try {
            if(turnoRepository.existsById(turno.getId()))
                turno = mapper.convertValue(turnoDTO, Turno.class);
                turnoRepository.save(turno);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo actualizar()");
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
