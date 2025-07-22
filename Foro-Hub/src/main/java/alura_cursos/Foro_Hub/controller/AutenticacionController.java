package alura_cursos.Foro_Hub.controller;

import alura_cursos.Foro_Hub.domain.model.usuario.DatosAutenticacionUsuario;
import alura_cursos.Foro_Hub.domain.model.usuario.DatosTokenJWT;
import alura_cursos.Foro_Hub.domain.model.usuario.Usuario;
import alura_cursos.Foro_Hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosTokenJWT> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        // Crea un objeto de autenticación con el email y la contraseña del usuario
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.contrasena()
        );
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(jwtToken));
    }
}
