package com.example.demo.repositories;

import com.example.demo.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :idCategoria order by titulo")
    List<Livro> findAllByCategoria(@Param(value = "idCategoria") Integer idCategoria);
}