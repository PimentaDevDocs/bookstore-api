package com.example.demo.services;

import com.example.demo.domain.Livro;
import com.example.demo.repositories.LivroRepository;
import com.example.demo.resources.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {

        Optional<Livro> livro = livroRepository.findById(id);

        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado. Id: " + id + " Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer idCategoria) {
        categoriaService.findById(idCategoria);

        return livroRepository.findAllByCategoria(idCategoria);
    }
}
