package TaskSpringBoot.repository;

import TaskSpringBoot.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByTituloContainingIgnoreCase(String titulo);
}
