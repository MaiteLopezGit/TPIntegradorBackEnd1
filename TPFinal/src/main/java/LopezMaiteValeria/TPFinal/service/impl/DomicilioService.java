package LopezMaiteValeria.TPFinal.service.impl;

import LopezMaiteValeria.TPFinal.model.DomicilioDTO;
import LopezMaiteValeria.TPFinal.model.Domicilio;
import LopezMaiteValeria.TPFinal.repository.IDomicilioRepository;
import LopezMaiteValeria.TPFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.*;

@Service
public class DomicilioService implements IService<DomicilioDTO> {

    @Autowired
    private IDomicilioRepository domicilioRepository;
    private final Logger logger = Logger.getLogger(DomicilioService.class);
    private ObjectMapper mapper;

    @Override
    public void crear(DomicilioDTO domicilioDTO) {
        logger.debug("Iniciando el metodo crear()");
            Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
            domicilioRepository.save(domicilio);

        logger.debug("Termino el metodo crear()");
    }

    @Override
    public DomicilioDTO buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar");
        Domicilio domicilio = null;
        DomicilioDTO domicilioDTO = null;
            if (domicilioRepository.findById(id).isPresent()) {
                domicilio = domicilioRepository.findById(id).get();
                domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            }
        logger.debug("Termino el metodo buscar");
        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Domicilio> domicilios = new ArrayList<>();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();

            domicilios = domicilioRepository.findAll();
            for (Domicilio domicilo : domicilios){
                domiciliosDTO.add(mapper.convertValue(domicilo,DomicilioDTO.class));
            }

        logger.debug("Termino el metodo buscarTodos()");
        return domiciliosDTO;
    }

    @Override
    public void actualizar(DomicilioDTO domicilioDTO) {
        logger.debug("Iniciando el metodo actualizar()");
            Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
            if(domicilioRepository.existsById(domicilio.getId()))
                domicilioRepository.save(domicilio);

        logger.debug("Termino el metodo actializar()");
    }

    @Override
    public void eliminar(Integer id) {
        logger.debug("Inciando metodo eliminar()");
            domicilioRepository.deleteById(id);

    }
}
