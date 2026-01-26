package com.joseph.bootcampDeloitte.service;

import com.joseph.bootcampDeloitte.model.Produto;
import com.joseph.bootcampDeloitte.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public boolean excluirProdutoPorId(Long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Produto atualizarProdutoPorId(Long id, Produto produtoAtualizado){
        produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto);
        }).orElse(null);
        return produtoAtualizado;
    }
}
