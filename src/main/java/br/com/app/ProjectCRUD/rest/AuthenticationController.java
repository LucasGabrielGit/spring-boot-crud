package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private UsuarioController usuarioController;

    @RequestMapping(value = "/authenticate")
    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtReq)
}
