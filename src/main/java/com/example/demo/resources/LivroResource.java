package com.example.demo.resources;

import com.example.demo.domain.Livro;
import com.example.demo.dtos.LivroDTO;
import com.example.demo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0")
                                                          Integer idCategoria) {
        List<Livro> livros = livroService.findAll(idCategoria);

        List<LivroDTO> dtoList = livros.stream().map(LivroDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtoList);
    }
}
