package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}