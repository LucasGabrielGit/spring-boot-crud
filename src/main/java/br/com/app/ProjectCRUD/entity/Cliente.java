package br.com.app.ProjectCRUD.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.br.CPF;

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
    @CPF(message = "{field.cpf.mandatory}")
    private Integer cpf;

    @Column(name = "data_nascimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy",
            timezone = "America/Brazil")
    private LocalDate dataNascimento;

    @Column(name = "data_registro")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy",
            timezone = "America/Brazil")
    private LocalDate dataRegistro;

}
