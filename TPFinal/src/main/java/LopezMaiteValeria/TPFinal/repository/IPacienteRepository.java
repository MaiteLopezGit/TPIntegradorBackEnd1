package LopezMaiteValeria.TPFinal.repository;


import LopezMaiteValeria.TPFinal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query("from Paciente p where p.apellido like %:apellido%")
    List<Paciente> obtenerPacientesConApellidoLike(@Param("apellido") String apellido);
}
