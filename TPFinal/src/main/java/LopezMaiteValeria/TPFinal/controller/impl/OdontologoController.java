package LopezMaiteValeria.TPFinal.controller.impl;

import LopezMaiteValeria.TPFinal.controller.IController;
import LopezMaiteValeria.TPFinal.model.OdontologoDTO;
import LopezMaiteValeria.TPFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController implements IController<OdontologoDTO> {

    @Autowired
    @Qualifier("odontologoService")
    private IService<OdontologoDTO> odontologoService;

    @Override
    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.crear(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos() {
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Integer id) {
        ResponseEntity<OdontologoDTO> response;
        OdontologoDTO odontologoDTO = odontologoService.buscar(id);
        if(odontologoDTO != null) {
            response = ResponseEntity.ok(odontologoDTO);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @PutMapping()
    public ResponseEntity<?> actualizar(@RequestBody OdontologoDTO odontologoDTO) {
         odontologoService.actualizar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
         odontologoService.eliminar(id);
       return ResponseEntity.ok("Se elimino correctamente el odontologo con id: " + id);

    }
}