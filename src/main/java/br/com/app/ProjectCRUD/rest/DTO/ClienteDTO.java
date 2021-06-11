package br.com.app.ProjectCRUD.rest.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private String nome;
    private Integer cpf;
    private String data_nascimento;
    private String data_registro;
}
