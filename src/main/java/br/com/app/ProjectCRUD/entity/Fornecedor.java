package br.com.app.ProjectCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_fornecedor", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFornecedor;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "tipo")
    private Integer tipo;

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnore
    private List<Produto> produtos;

}
