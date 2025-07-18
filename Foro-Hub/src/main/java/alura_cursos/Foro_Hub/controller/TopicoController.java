package alura_cursos.Foro_Hub.controller;

import alura_cursos.Foro_Hub.domain.model.curso.Curso;
import alura_cursos.Foro_Hub.domain.model.curso.CursoRepository;
import alura_cursos.Foro_Hub.domain.model.usuario.Usuario;
import alura_cursos.Foro_Hub.domain.model.usuario.UsuarioRepository;
import alura_cursos.Foro_Hub.domain.topico.CrearTopicoDto;
import alura_cursos.Foro_Hub.domain.topico.DetallesTopicoDto;
import alura_cursos.Foro_Hub.domain.topico.Topico;
import alura_cursos.Foro_Hub.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController // Marca la clase como un controlador REST
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetallesTopicoDto> crearTopico(@RequestBody @Valid CrearTopicoDto datos, UriComponentsBuilder uriBuilder) {

        Optional<Usuario> autorOptional = usuarioRepository.findById(datos.autorId());
        if (autorOptional.isEmpty()) {
            throw new IllegalArgumentException("Autor no encontrado con ID: " + datos.autorId());
        }
        Usuario autor = autorOptional.get();

        Curso curso = cursoRepository.findByNombreIgnoreCase(datos.nombreCurso())
                .orElseGet(() -> cursoRepository.save(new Curso(datos.nombreCurso())));

        // Validando si el topico existe
        if (topicoRepository.existsByTituloIgnoreCaseAndMensajeIgnoreCase(datos.titulo(), datos.mensaje())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        topicoRepository.save(topico);

        // Construye la URI para el nuevo recurso creado (siguiendo las buenas prácticas REST)
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        // Devuelve una respuesta 201 Created con el DTO de detalles del topico y la URI
        return ResponseEntity.created(uri).body(new DetallesTopicoDto(topico));
    }

}
