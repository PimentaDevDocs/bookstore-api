package com.example.demo.dtos;

import com.example.demo.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 2746474708767442982L;
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser nulo.")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO não pode ser nulo.")
    @Length(min = 3, max = 100, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {

        super();
    }

    public CategoriaDTO(Categoria categoria) {

        super();
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }
}
