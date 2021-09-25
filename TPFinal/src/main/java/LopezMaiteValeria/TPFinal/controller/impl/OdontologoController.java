package LopezMaiteValeria.TPFinal.controller.impl;

import LopezMaiteValeria.TPFinal.controller.IController;
import LopezMaiteValeria.TPFinal.model.DTO.OdontologoDTO;
import LopezMaiteValeria.TPFinal.model.Odontologo;
import LopezMaiteValeria.TPFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController implements IController<OdontologoDTO> {

    @Autowired
    @Qualifier("odontologoService")
    private IService<OdontologoDTO> odontologoService;

    @Override
    @PostMapping("/crear")
    public ResponseEntity<OdontologoDTO> crear(@RequestBody OdontologoDTO odontologoDTO) {
        ResponseEntity<Odontologo> response;
        Odontologo odontologoCreado = odontologoService.crear(odontologo);
        if(odontologoCreado != null) {
            response = ResponseEntity.ok(odontologoCreado);
        } else {
            response = ResponseEntity.badRequest().body(odontologo);
        }
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Integer id) {
        ResponseEntity<Odontologo> response;
        Odontologo odontologo = odontologoIService.buscar(id);
        if(odontologo != null) {
            response = ResponseEntity.ok(odontologo);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @PutMapping()
    public ResponseEntity<OdontologoDTO> actualizar(OdontologoDTO odontologoDTO) {
        ResponseEntity<Odontologo> response;
        Odontologo odontologoActualizado;
        if (odontologo.getId() != null && odontologoIService.buscar(odontologo.getId()) != null) {
            odontologoActualizado = odontologoIService.actualizar(odontologo);
            if (odontologoActualizado != null) {
                response = ResponseEntity.ok(odontologoActualizado);
            } else {
                response = ResponseEntity.badRequest().body(odontologo);
            }
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(Integer id) {
        ResponseEntity<String> response;
        if (odontologoIService.buscar(id) != null) {
            odontologoIService.eliminar(id);
            response = ResponseEntity.ok("Se elimino correctamente el odontologo con id: " + id);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<OdontologoDTO>> buscarTodos() {
        return ResponseEntity.ok(odontologoIService.buscarTodos());
    }
}
