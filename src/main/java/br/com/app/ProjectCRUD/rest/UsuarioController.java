package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.entity.Usuario;
import br.com.app.ProjectCRUD.repository.UsuarioRepository;
import br.com.app.ProjectCRUD.rest.DTO.UsuarioDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/sistema/usuarios")
public class UsuarioController {


    private final UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuario.getNome());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setEmail(usuarioDTO.getEmail());

        return repository.save(usuario);
    }

    @GetMapping("all")
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @GetMapping
    public List<Usuario> findUserByUsername(
            @RequestParam(value = "username", required = false) String username
    ) {
        return repository.findByUsername("%" + username);
    }

    public Usuario getUsuarioById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado!")
        );
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
        repository.findById(id).map(usuario -> {
            usuarioAtualizado.setIdUsuario(usuario.getIdUsuario());
            return repository.save(usuarioAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id) {
        repository.findById(id).map(usuario -> {
            repository.delete(usuario);
            return Void.TYPE;
        });
    }

}
