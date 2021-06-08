package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.entity.Cliente;
import br.com.app.ProjectCRUD.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/sistema/clientes")
public class ClientesController {

    private final ClientesRepository repository;

    @Autowired
    public ClientesController(ClientesRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Cliente getById(@PathVariable Integer Id) {
        return repository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado!"
                )
        );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        repository.findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
        repository.findById(id).map(cliente -> {
            clienteAtualizado.setIdCliente(cliente.getIdCliente());
            return repository.save(clienteAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
