package br.com.app.ProjectCRUD.repository;

import br.com.app.ProjectCRUD.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    @Query("SELECT f FROM Fornecedor f " +
            "WHERE UPPER(f.nome) like UPPER(:nome)")
    List<Fornecedor> findByName(@Param("nome") String nome);

}