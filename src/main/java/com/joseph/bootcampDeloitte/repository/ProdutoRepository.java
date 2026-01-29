package com.joseph.bootcampDeloitte.repository;

import com.joseph.bootcampDeloitte.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeContaining(String nome);
    boolean existsByNome(String nome);
}
