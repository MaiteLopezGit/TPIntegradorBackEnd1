package LopezMaiteValeria.TPFinal.controller;

import LopezMaiteValeria.TPFinal.model.OdontologoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface IController<T> {

    ResponseEntity<?> crear(T t);

    ResponseEntity<Set<T>> buscarTodos();

    ResponseEntity<T> buscar(Integer id);

    ResponseEntity<?> actualizar(T t);

    ResponseEntity<String> eliminar(Integer id);
}
