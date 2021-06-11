package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.entity.Categoria;
import br.com.app.ProjectCRUD.repository.CategoriaRepository;
import br.com.app.ProjectCRUD.rest.DTO.CategoriaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sistema/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    @GetMapping("all")
    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria salvar(@RequestBody CategoriaDTO categoriaDTO
    ) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(categoriaDTO.getDescricao());
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        categoriaRepository.findById(id).map(
                categoria -> {
                    categoriaRepository.delete(categoria);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }


}
