package com.joseph.bootcampDeloitte.repository;

import com.joseph.bootcampDeloitte.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    List<Produto> findByNomeContaining(String nome);
}
