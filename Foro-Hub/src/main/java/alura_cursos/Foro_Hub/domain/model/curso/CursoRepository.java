package alura_cursos.Foro_Hub.domain.model.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
        Optional<Curso> findByNombreIgnoreCase(String nombre);
}
