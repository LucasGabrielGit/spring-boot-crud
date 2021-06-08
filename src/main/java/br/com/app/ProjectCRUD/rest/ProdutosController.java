package br.com.app.ProjectCRUD.rest;

import br.com.app.ProjectCRUD.entity.Categoria;
import br.com.app.ProjectCRUD.entity.Fornecedor;
import br.com.app.ProjectCRUD.entity.Produto;
import br.com.app.ProjectCRUD.repository.CategoriaRepository;
import br.com.app.ProjectCRUD.repository.FornecedorRepository;
import br.com.app.ProjectCRUD.repository.ProdutosRepository;
import br.com.app.ProjectCRUD.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sistema/produtos")
public class ProdutosController {

    private final ProdutosRepository produtosRepository;
    private final FornecedorRepository fornecedorRepository;
    private final CategoriaRepository categoriaRepository;
    private final BigDecimalConverter bigDecimalConverter;


    @GetMapping("/all")
    public List<Produto> getAll() {
        return produtosRepository.findAll();
    }

    @GetMapping
    public List<Produto> search(@RequestParam(value = "cod_produto") Integer cod) {
        return produtosRepository.findByCod(cod);
    }

    @PostMapping
    public @ResponseBody
    Produto salvar(@RequestBody ProdutoDTO produto_dto) {
        Produto p = new Produto();
        Integer codProduto = produto_dto.getCod_produto();
        Integer idFornecedor = produto_dto.getId_fornecedor();
        Integer idCategoria = produto_dto.getId_categoria();

        Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Fornecedor inexistente!")
        );

        Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada!")
        );

        p.setCodProduto(produto_dto.getCod_produto());
        p.setDescricao(produto_dto.getDescricao());
        p.setValor(bigDecimalConverter.converter(produto_dto.getValor()));
        p.setFornecedor(fornecedor);
        p.setCategoria(categoria);
        return produtosRepository.save(p);

    }
}
