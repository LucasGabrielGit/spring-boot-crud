package br.com.app.ProjectCRUD.rest.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class FornecedorDTO {

    private String nome;
    private String data_cadastro;
    private Integer tipo;

}
