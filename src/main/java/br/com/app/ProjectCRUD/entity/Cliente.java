package br.com.app.ProjectCRUD.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_clientes", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_registro")
    private LocalDate dataRegistro;

}
