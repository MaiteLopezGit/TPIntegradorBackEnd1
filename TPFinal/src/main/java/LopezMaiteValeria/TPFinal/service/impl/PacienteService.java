package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.PacienteDTO;
import LopezMaiteValeria.TPFinal.model.Paciente;
import LopezMaiteValeria.TPFinal.repository.IPacienteRepository;
import LopezMaiteValeria.TPFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class PacienteService implements IService<PacienteDTO> {

    @Autowired
    IPacienteRepository pacienteRepository;

    private final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void crear(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        try {
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el medoto crear()");
    }

    @Override
    public PacienteDTO buscar(Integer id) {
        Paciente pacienteEncontrado = null;
        PacienteDTO pacienteDTO = null;
        try {
            if(pacienteRepository.findById(id).isPresent())
            {
                pacienteEncontrado = pacienteRepository.findById(id).get();
                pacienteDTO = mapper.convertValue(pacienteEncontrado, PacienteDTO.class);
            }
            else
                throw new Exception("No se encontro el paciente con el id: " +id+ " buscado");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscar()");
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Paciente> pacientes = new ArrayList<>();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        try {
            pacientes = pacienteRepository.findAll();
            for(Paciente paciente : pacientes){
                pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscarTodos()");
        return pacientesDTO;
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        logger.debug("Iniciando el metodo actualizar()");
        Paciente paciente = null;
        try {
            paciente = mapper.convertValue(pacienteDTO, Paciente.class);
            if(pacienteRepository.existsById(paciente.getId()))
                pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminado el metodo actualizar()");
    }

    @Override
    public void eliminar(Integer id) {
        logger.debug("Iniciando el metodo eliminar()");
        try {
            pacienteRepository.deleteById(id);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.debug("Finalizando el metodo eliminar()");
    }
}
