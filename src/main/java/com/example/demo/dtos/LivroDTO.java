package com.example.demo.dtos;

import com.example.demo.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 2983372355110659146L;

    private Integer id;
    private String titulo;
    private String nomeAutor;
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
