package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.entity.Fornecedor;
import br.com.app.ProjectCRUD.repository.FornecedorRepository;
import br.com.app.ProjectCRUD.rest.DTO.FornecedorDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sistema/fornecedores")
public class FornecedorController {

    private final FornecedorRepository fornecedorRepository;

    @GetMapping("all")
    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    @GetMapping
    public List<Fornecedor> findFornecedorByName(
            @RequestParam(value = "nome", required = false) String nome
    ) {
        return fornecedorRepository.findByName("%" + nome);
    }

    @GetMapping("{id}")
    public Fornecedor getFornecedorById(@PathVariable Integer id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado!")
                );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody Fornecedor fornecedorAtualizado) {
        fornecedorRepository.findById(id).map(fornecedor -> {
            fornecedorAtualizado.setIdFornecedor(fornecedor.getIdFornecedor());
            return fornecedorRepository.save(fornecedorAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor salvar(@RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();

        LocalDate data = LocalDate.parse(fornecedorDTO.getData_cadastro(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setDataCadastro(data);
        fornecedor.setTipo(fornecedorDTO.getTipo());
        return fornecedorRepository.save(fornecedor);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        fornecedorRepository.findById(id).map(
                fornecedor -> {
                    fornecedorRepository.delete(fornecedor);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

}
