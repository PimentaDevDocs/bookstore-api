package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Categoria;
import com.example.demo.dominio.Livro;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		if (categoriaRepository.count() == 0) {

			Categoria categoria;
			Livro livro;

			for (int i = 0; i < 10; i++) {
				categoria = new Categoria(null, "Informática " + i, "Livros de TI" + i);

				livro = new Livro(null, "Clean code " + i, "Robert Martin " + i, "Lorem ipsum " + i, categoria);

				categoria.getLivros().add(livro);

				this.categoriaRepository.save(categoria);
				this.livroRepository.save(livro);
			}
		}
	}

}
