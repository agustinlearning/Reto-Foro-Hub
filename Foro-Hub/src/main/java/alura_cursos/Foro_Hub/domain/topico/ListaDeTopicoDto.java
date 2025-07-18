package alura_cursos.Foro_Hub.domain.topico;

import java.time.LocalDateTime;

//Este codigo podria ser redundante considerando que es igual al de DetallesTopicos, conciderarlo mas tarde
public record ListaDeTopicoDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autorNombre,
        String cursoNombre
) {
    public ListaDeTopicoDto(Topico topico) {
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
