package alura_cursos.Foro_Hub.domain.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Optional<Usuario> findByEmail(String email);

    UserDetails findByEmail(String email);
}
