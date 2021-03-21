package com.example.demo.dtos;

import com.example.demo.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 2983372355110659146L;

    private Integer id;
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro livro) {
        super();
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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


}
