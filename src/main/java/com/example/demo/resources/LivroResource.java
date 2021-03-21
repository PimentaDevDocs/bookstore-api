package com.example.demo.resources;

import com.example.demo.domain.Livro;
import com.example.demo.dtos.LivroDTO;
import com.example.demo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PutMapping
    public ResponseEntity<Livro> update(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.update(livroDTO);
        return ResponseEntity.ok().body(livro);
    }

    @PatchMapping
    public ResponseEntity<Livro> updatePatch(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.update(livroDTO);
        return ResponseEntity.ok().body(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria,
                                        @RequestBody LivroDTO livroDTO) {

        Livro livro = livroService.create(idCategoria, livroDTO);

        URI uri =
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }
}
