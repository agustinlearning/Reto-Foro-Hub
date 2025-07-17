package alura_cursos.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearTopicoDto(
        @NotBlank(message = "El título no puede estar vacío.")
        String titulo,

        @NotBlank(message = "El mensaje no puede estar vacío.")
        String mensaje,

        @NotNull(message = "El ID del autor no puede ser nulo.")
        Long autorId,

        @NotBlank(message = "El nombre del curso no puede estar vacío.")
        String nombreCurso
) {
}
