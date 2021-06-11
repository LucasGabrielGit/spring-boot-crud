package br.com.app.ProjectCRUD.rest.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDTO {
    private Integer cod_produto;
    private String descricao;
    private String valor;
    private Integer id_fornecedor;
    private Integer id_categoria;
}
