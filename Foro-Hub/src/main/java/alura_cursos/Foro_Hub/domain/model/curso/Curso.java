package alura_cursos.Foro_Hub.domain.model.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Curso(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

        // Constructor simplificado para cuando solo se conoce el nombre
    public Curso(String nombre) {
        this.nombre = nombre;
        this.categoria = "General"; // Categoría por defecto si no se especifica
    }
}
