package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.PacienteDTO;
import LopezMaiteValeria.TPFinal.model.Paciente;
import LopezMaiteValeria.TPFinal.repository.IPacienteRepository;
import LopezMaiteValeria.TPFinal.service.IPacienteService;
import LopezMaiteValeria.TPFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    private final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void crear(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
            pacienteRepository.save(paciente);
        logger.debug("Terminando el medoto crear()");
    }

    @Override
    public PacienteDTO buscar(Integer id) {
        Paciente pacienteEncontrado = null;
        PacienteDTO pacienteDTO = null;
            if(pacienteRepository.findById(id).isPresent())
            {
                pacienteEncontrado = pacienteRepository.findById(id).get();
                pacienteDTO = mapper.convertValue(pacienteEncontrado, PacienteDTO.class);
            }

        logger.debug("Terminando el metodo buscar()");
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Paciente> pacientes = new ArrayList<>();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

          pacientes = pacienteRepository.findAll();
            for(Paciente paciente : pacientes){
                pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
            }

        logger.debug("Terminando el metodo buscarTodos()");
        return pacientesDTO;
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        logger.debug("Iniciando el metodo actualizar()");
        Paciente paciente = null;
            paciente = mapper.convertValue(pacienteDTO, Paciente.class);
            if(pacienteRepository.existsById(paciente.getId()))
                pacienteRepository.save(paciente);

        logger.debug("Terminado el metodo actualizar()");
    }

    @Override
    public void eliminar(Integer id) {
        logger.debug("Iniciando el metodo eliminar()");

            pacienteRepository.deleteById(id);
        logger.debug("Finalizando el metodo eliminar()");
    }

    @Override
    public Set<PacienteDTO> buscarPacientesConApellidoLike(String apellido) {
        List<Paciente> pacientes =  pacienteRepository.obtenerPacientesConApellidoLike(apellido);

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }
}
