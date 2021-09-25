package LopezMaiteValeria.TPFinal.repository;

import LopezMaiteValeria.TPFinal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
