package com.lojadegames.lojadegames.repository;

import com.lojadegames.lojadegames.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        List<Produto> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
    }