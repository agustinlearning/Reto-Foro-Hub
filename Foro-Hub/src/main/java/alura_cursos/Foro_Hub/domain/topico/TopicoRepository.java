package alura_cursos.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{

    boolean existsByTituloIgnoreCase(String titulo);

    Page<Topico> findAll(Pageable pageable);

    boolean existsByTituloIgnoreCaseAndMensajeIgnoreCase(@NotBlank(message = "El título no puede estar vacío.") String titulo, @NotBlank(message = "El mensaje no puede estar vacío.") String mensaje);
}
