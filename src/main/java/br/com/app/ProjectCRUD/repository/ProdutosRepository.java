package br.com.app.ProjectCRUD.repository;

import br.com.app.ProjectCRUD.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

    @Query("select p, p.fornecedor.nome, p.categoria.descricao from Produto p " +
            "join p.categoria c " +
            "join p.fornecedor f" +
            " where p.codProduto =:cod_produto " +
            " and p.fornecedor.idFornecedor= f.idFornecedor" +
            " and p.categoria.idCategoria = c.idCategoria")
    List<Produto> findByCod(@Param("cod_produto") Integer cod);

}