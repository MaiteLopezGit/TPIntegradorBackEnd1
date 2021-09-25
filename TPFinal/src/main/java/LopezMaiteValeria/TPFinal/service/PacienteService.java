package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Paciente;
import LopezMaiteValeria.TPFinal.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

@Service
public class PacienteService implements IService<Paciente>{

    @Autowired
    IPacienteRepository pacienteRepository;

    private final Logger logger = Logger.getLogger(PacienteService.class);

    @Override
    public Paciente crear(Paciente paciente) {
        Paciente pacienteCreado = null;
        try {
            pacienteCreado = pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el medoto crear()");
        return pacienteCreado;
    }

    @Override
    public Paciente buscar(Integer id) {
        Paciente pacienteEncontrado = null;
        try {
            if(pacienteRepository.findById(id).isPresent())
                pacienteEncontrado = pacienteRepository.findById(id).get();
            else
                throw new Exception("No se encontro el paciente con el id: " +id+ " buscado");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscar()");
        return pacienteEncontrado;
    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Paciente> pacientes = new ArrayList<>();
        try {
            pacientes = pacienteRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo buscarTodos()");
        return pacientes;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        logger.debug("Iniciando el metodo actualizar()");
        Paciente pacienteActualizado = null;
        try {
            if(pacienteRepository.existsById(paciente.getId()))
                pacienteActualizado = pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminado el metodo actualizar()");
        return pacienteActualizado;
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
