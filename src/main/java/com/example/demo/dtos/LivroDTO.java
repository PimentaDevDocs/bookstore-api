package com.example.demo.dtos;

import com.example.demo.domain.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 2983372355110659146L;

    private Integer id;

    @NotEmpty(message = "Campo TÍTULO não pode ser nulo.")
    @Length(min = 3, max = 100, message = "O campo TÍTULO deve ter entre 3 e 100 caracteres.")
    private String titulo;

    @NotEmpty(message = "Campo NOME AUTOR não pode ser nulo.")
    @Length(min = 3, max = 100, message = "O campo NOME AUTOR deve ter entre 3 e 100 caracteres.")
    private String nomeAutor;

    @NotEmpty(message = "Campo TEXTO não pode ser nulo.")
    @Length(min = 3, max = 200, message = "O campo TEXTO deve ter entre 3 e 100 caracteres.")
    private String texto;

    public LivroDTO() {

    }

    public LivroDTO(Livro livro) {

        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getNomeAutor() {

        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {

        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {

        return texto;
    }

    public void setTexto(String texto) {

        this.texto = texto;
    }
}
