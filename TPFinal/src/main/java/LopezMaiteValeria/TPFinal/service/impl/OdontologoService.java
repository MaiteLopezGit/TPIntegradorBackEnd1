package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.DTO.OdontologoDTO;
import LopezMaiteValeria.TPFinal.model.Odontologo;
import LopezMaiteValeria.TPFinal.repository.IOdontologoRepository;
import LopezMaiteValeria.TPFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IService<OdontologoDTO>{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private final Logger logger = Logger.getLogger(OdontologoService.class);

    //@Override
    public void crear(OdontologoDTO odontologoDTO) {
        logger.debug("Iniciando el metodo crear()");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        Odontologo odontologoNuevo = null;
        try {
            odontologoNuevo = odontologoRepository.save(odontologo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo crear()");
    }

    //@Override
    public OdontologoDTO buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar()");
        OdontologoDTO odontologoDTO = null;
        Odontologo odontologoBuscado = null;
        try {
            if (odontologoRepository.findById(id).isPresent()) {
                odontologoBuscado = odontologoRepository.findById(id).get();
                odontologoDTO = mapper.convertValue(odontologoBuscado, OdontologoDTO.class);
            } else
                throw new Exception("No se encontro el odontologo con el id: " + id + " buscado");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscar()");
        return odontologoDTO;
    }

    //@Override
    public void actualizar(OdontologoDTO odontologoDTO) {
        Odontologo odontologoActualizado = mapper.convertValue(odontologoDTO, Odontologo.class);

        try {
            if(odontologoRepository.existsById(odontologoActualizado.getId()))
                odontologoRepository.save(odontologoActualizado);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    //@Override
    public Collection<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        try {
            odontologos = odontologoRepository.findAll();
            for(Odontologo odontologo: odontologos) {
                odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscarTodos()");
        return odontologosDTO;
    }

    //@Override
    public void eliminar(Integer id) {
        try {
            odontologoRepository.deleteById(id);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
