package br.com.app.ProjectCRUD.repository;

import br.com.app.ProjectCRUD.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u " +
            "WHERE UPPER(u.username) like UPPER(:username)")
    List<Usuario> findByUsername(@Param("username") String username);
}