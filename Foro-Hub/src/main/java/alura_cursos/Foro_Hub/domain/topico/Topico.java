package alura_cursos.Foro_Hub.domain.topico;

import alura_cursos.Foro_Hub.domain.model.curso.Curso;
import alura_cursos.Foro_Hub.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ABIERTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = Estado.ABIERTO;
    }

    public void actualizarDatos(String titulo, String mensaje, Estado estado) { // mas tarde cambbiar por el dto de topicos
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
        }
        if (mensaje != null && !mensaje.isBlank()) {
            this.mensaje = mensaje;
        }
        if (estado != null) {
            this.estado = estado;
        }
    }

    public void cerrarTopico() {
        this.estado = Estado.CERRADO;
    }
}
