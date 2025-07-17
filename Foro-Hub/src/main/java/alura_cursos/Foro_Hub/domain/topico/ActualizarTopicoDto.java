package alura_cursos.Foro_Hub.domain.topico;

public record ActualizarTopicoDto(
        String titulo,
        String mensaje,
        Estado estado
) {
}
