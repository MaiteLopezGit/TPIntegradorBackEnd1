package LopezMaiteValeria.TPFinal.controller.impl;

import LopezMaiteValeria.TPFinal.controller.IController;
import LopezMaiteValeria.TPFinal.model.OdontologoDTO;
import LopezMaiteValeria.TPFinal.model.Paciente;
import LopezMaiteValeria.TPFinal.model.PacienteDTO;
import LopezMaiteValeria.TPFinal.service.IPacienteService;
import LopezMaiteValeria.TPFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController implements IController<PacienteDTO> {
    @Autowired
    private IPacienteService pacienteService;

    @Override
    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crear(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @GetMapping("/buscarTodos")
    public ResponseEntity<Set<PacienteDTO>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Integer id) {
        ResponseEntity<PacienteDTO> response;
        PacienteDTO pacienteDTO = pacienteService.buscar(id);
        if(pacienteDTO != null) {
            response = ResponseEntity.ok(pacienteDTO);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @Override
    @PutMapping()
    public ResponseEntity<?> actualizar(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.actualizar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Se elimino correctamente el paciente con id: " + id);

    }

    @GetMapping("/listaApellido")
    public Set<PacienteDTO> buscarPorApellido(@RequestParam String apellido){
        return pacienteService.buscarPacientesConApellidoLike(apellido);
    }
}
