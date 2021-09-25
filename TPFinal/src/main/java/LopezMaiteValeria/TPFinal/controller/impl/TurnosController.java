package LopezMaiteValeria.TPFinal.controller.impl;

import LopezMaiteValeria.TPFinal.controller.IController;
import LopezMaiteValeria.TPFinal.model.OdontologoDTO;
import LopezMaiteValeria.TPFinal.model.Turno;
import LopezMaiteValeria.TPFinal.model.TurnoDTO;
import LopezMaiteValeria.TPFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnosController implements IController<TurnoDTO> {

    @Autowired
    @Qualifier("turnoService")
    private IService<TurnoDTO> turnoService;

    @Override
    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) TurnoDTO turnoDTO) {
        turnoService.crear(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<TurnoDTO>> buscarTodos() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Integer id) {
        ResponseEntity<TurnoDTO> response;
        TurnoDTO turnoDTO = turnoService.buscar(id);
        if(turnoDTO != null) {
            response = ResponseEntity.ok(turnoDTO);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @PutMapping()
    public ResponseEntity<?> actualizar(@RequestBody TurnoDTO turnoDTO) {
        turnoService.actualizar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        turnoService.eliminar(id);
        return ResponseEntity.ok("Se elimino correctamente el turno con id: " + id);
    }
}
