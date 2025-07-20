package alura_cursos.Foro_Hub.domain.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosAutenticacionUsuario(
        @Email(message = "El email debe ser válido.")
        String email,

        @NotBlank(message = "La contraseña es obligatoria.")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
        String contrasena
) {
}
