package TaskSpringBoot.service;

import TaskSpringBoot.model.Tarea;
import TaskSpringBoot.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TareaService {


    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public List<Tarea> buscarTareasPorNombre(String nombre) {
        return tareaRepository.findByTituloContainingIgnoreCase(nombre);
    }
}
