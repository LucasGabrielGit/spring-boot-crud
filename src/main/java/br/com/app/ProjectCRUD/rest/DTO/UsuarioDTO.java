package br.com.app.ProjectCRUD.rest.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String nome;
    private String username;
    private String password;
    private String email;
}
