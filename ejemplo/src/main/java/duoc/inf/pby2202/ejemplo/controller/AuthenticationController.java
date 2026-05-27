package duoc.inf.pby2202.ejemplo.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duoc.inf.pby2202.ejemplo.model.Usuario;
import duoc.inf.pby2202.ejemplo.repository.UsuarioRepository;
import duoc.inf.pby2202.ejemplo.security.JwtUtil;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private AuthenticationManager authManager;
    private UsuarioRepository usuarioRepo;
    private PasswordEncoder encoder;
    private JwtUtil utils;

    public AuthenticationController(
        AuthenticationManager authManager, 
        UsuarioRepository usuarioRepo, 
        PasswordEncoder encoder, 
        JwtUtil utils
    ) {
        this.authManager = authManager;
        this.usuarioRepo = usuarioRepo;
        this.encoder = encoder;
        this.utils = utils;
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestBody Usuario user) {
        Authentication authentication = authManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return utils.generateToken(userDetails.getUsername());
    }

    @PostMapping("/registrar")
    public String registerUser(@RequestBody Usuario user) {
        if (usuarioRepo.existsByUsername(user.getUsername())) {
            return "User already exists!";
        }

        final Usuario newUser = new Usuario(
                null,
                user.getUsername(),
                encoder.encode(user.getPassword())
        );
        usuarioRepo.save(newUser);
        return "User registered successfully!";
    }
}
