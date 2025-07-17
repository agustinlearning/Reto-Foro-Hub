package alura_cursos.Foro_Hub.domain.topico;

import java.time.LocalDateTime;

public record DetallesTopicoDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autorNombre,
        String cursoNombre
) {
    public DetallesTopicoDto(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado().toString(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
