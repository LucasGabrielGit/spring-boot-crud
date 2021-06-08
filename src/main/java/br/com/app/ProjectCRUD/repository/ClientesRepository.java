package br.com.app.ProjectCRUD.repository;

import br.com.app.ProjectCRUD.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

}