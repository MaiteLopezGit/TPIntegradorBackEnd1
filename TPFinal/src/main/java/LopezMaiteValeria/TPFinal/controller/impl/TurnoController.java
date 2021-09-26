package LopezMaiteValeria.TPFinal.controller.impl;

import LopezMaiteValeria.TPFinal.model.Turno;
import LopezMaiteValeria.TPFinal.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @PostMapping()
    public ResponseEntity<?> agregarTurno (@RequestBody Turno turno){
        turnoService.crearTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/buscarTodos")
    public List<Turno> buscarTodos(){
        return turnoService.buscarTodos();
    }
}
