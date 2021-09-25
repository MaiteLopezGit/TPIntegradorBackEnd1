package LopezMaiteValeria.TPFinal.service;

import LopezMaiteValeria.TPFinal.model.Odontologo;
import LopezMaiteValeria.TPFinal.repository.IOdontologoRepository;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService implements IService<Odontologo>{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    private final Logger logger = Logger.getLogger(OdontologoService.class);
    @Override
    public Odontologo crear(Odontologo odontologo) {
        logger.debug("Iniciando el metodo crear()");
        Odontologo odontologoNuevo =null;
        try {
            odontologoNuevo = odontologoRepository.save(odontologo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Terminando el metodo crear()");
        return odontologoNuevo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        logger.debug("Iniciando el metodo buscar()");
        Odontologo odontologoBuscado = null;
        try {
            if(odontologoRepository.findById(id).isPresent())
                odontologoBuscado = odontologoRepository.findById(id).get();
            else
                throw new Exception("No se encontro el odontologo con el id: " + id + " buscado");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscar()");
        return odontologoBuscado;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            odontologos = odontologoRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.debug("Termino el metodo buscarTodos()");
        return odontologos;
    }


    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Odontologo odontologoActualizado = null;
        try {
            if(odontologoRepository.existsById(odontologo.getId()))
                odontologoActualizado = odontologoRepository.save(odontologo);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return odontologoActualizado;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            odontologoRepository.deleteById(id);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
