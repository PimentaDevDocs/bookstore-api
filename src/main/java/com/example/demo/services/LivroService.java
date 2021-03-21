package com.example.demo.services;

import com.example.demo.domain.Livro;
import com.example.demo.repositories.LivroRepository;
import com.example.demo.resources.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {

        Optional<Livro> livro = livroRepository.findById(id);

        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado. Id: " + id + " Tipo: " + Livro.class.getName()));
    }

}
