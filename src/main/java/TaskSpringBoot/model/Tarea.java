package TaskSpringBoot.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tareas")

public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255, nullable = true)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private LocalTime horaCreacion;

    @Column(length = 50, nullable = false)
    private String estado;

    public void setHoraCreacion(LocalTime now) {
    }

    public void setFechaCreacion(LocalDate now) {
    }

    // Getters y setters


}
