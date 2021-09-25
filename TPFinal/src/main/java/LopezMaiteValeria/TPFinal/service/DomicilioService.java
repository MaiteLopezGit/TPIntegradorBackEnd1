package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Domicilio;
import LopezMaiteValeria.TPFinal.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService implements IService<Domicilio>{

    @Autowired
    private IDomicilioRepository domicilioRepository;

    private final Logger logger = Logger.getLogger(DomicilioService.class);

    @Override
    public Domicilio crear(Domicilio domicilio) {
        logger.debug("Iniciando el metodo crear()");
        Domicilio domicilioNuevo = null;
        try {
            domicilioNuevo = domicilioRepository.save(domicilio);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo crear()");
        return domicilioNuevo;
    }

    @Override
    public Domicilio buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar");
        Domicilio domicilio = null;
        try {
            if (domicilioRepository.findById(id).isPresent())
                domicilio = domicilioRepository.findById(id).get();
            else
                throw  new Exception("No se encontro el domicilio con id: " + id + " buscado");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscar");
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        logger.debug("Iniciando el metodo buscarTodos()");
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            domicilios = domicilioRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscarTodos()");
        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        logger.debug("Iniciando el metodo actualizar()");
        Domicilio domicilioConActualizaciones = null;
        try {
            if(domicilioRepository.existsById(domicilio.getId()))
                domicilioConActualizaciones = domicilioRepository.save(domicilio);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo actializar()");
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {
        logger.debug("Inciando metodo eliminar()");
        try {
            domicilioRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
