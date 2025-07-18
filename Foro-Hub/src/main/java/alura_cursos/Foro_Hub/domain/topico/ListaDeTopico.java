package alura_cursos.Foro_Hub.domain.topico;

import java.time.LocalDateTime;

//Este codigo tiene que devolver un page y retonar los primeros 10 topicos ordernados por fecha de creacion, hacerlo mas tarde
public record ListaDeTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autorNombre,
        String cursoNombre
) {
    public ListaDeTopico(Topico topico) {
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
