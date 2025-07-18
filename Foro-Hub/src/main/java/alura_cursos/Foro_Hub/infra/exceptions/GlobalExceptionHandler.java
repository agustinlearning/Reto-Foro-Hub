package alura_cursos.Foro_Hub.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice // Marca la clase como un manejador global de excepciones para controladores REST
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DatosErrorValidacion>> manejarErrorValidacion(MethodArgumentNotValidException ex) {
        // Obtiene todos los errores de campo de la excepción
        List<FieldError> errores = ex.getFieldErrors();
        // Mapea los errores a un DTO personalizado para la respuesta
        return ResponseEntity.badRequest().body(errores.stream()
                .map(DatosErrorValidacion::new)
                .collect(Collectors.toList()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // DTO interno para representar un error de validación
    // record dentro de la clase, metodo encontrado en internet, me parecio interesante para retornar un DTO
    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
