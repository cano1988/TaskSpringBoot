package TaskSpringBoot.controller;


import TaskSpringBoot.model.Tarea;
import TaskSpringBoot.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/tareas")

public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public String listarTareas(Model model) {
        model.addAttribute("tareas", tareaService.getAllTareas());
        return "lista-tareas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "formulario-tarea";
    }

    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        tarea.setFechaCreacion(LocalDate.now());
        tarea.setHoraCreacion(LocalTime.now());
        tareaService.saveTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.getTareaById(id).orElseThrow(() -> new IllegalArgumentException("ID de tarea inválido: " + id));
        model.addAttribute("tarea", tarea);
        return "formulario-tarea";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
        return "redirect:/tareas";
    }

    @GetMapping("/buscar")
    public String buscarTareas(@RequestParam String nombre, Model model) {
        model.addAttribute("tareas", tareaService.buscarTareasPorNombre(nombre));
        return "lista-tareas";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalleTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.getTareaById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de tarea inválido: " + id));
        model.addAttribute("tarea", tarea);
        return "detalle-tarea";
    }
}
