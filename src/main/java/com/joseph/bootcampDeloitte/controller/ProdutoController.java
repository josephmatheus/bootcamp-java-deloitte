package com.joseph.bootcampDeloitte.controller;

import com.joseph.bootcampDeloitte.model.Produto;
import com.joseph.bootcampDeloitte.service.ProdutoService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public Object listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            return "Não há nenhum produto cadastrado";
        }
        return produtos;
    }

    @GetMapping("/produtos/{id}")
    public Object buscarProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        if (produto == null) {
            return "Nenhum produto encontrado com este ID";
        }
        return produto;
    }

    @PostMapping("/produtos")
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public String excluirProduto(@PathVariable Long id) {
        boolean excluido = produtoService.excluirProdutoPorId(id);
        if (excluido) {
            return "Produto deletado com sucesso";
        }
        return "Nenhum produto encontrado com este ID";
    }
    
    @PutMapping("/produtos/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProdutoPorId(id, produto);
    }

    @GetMapping("/hello")
    public String hello() {
        return "API de Produtos rodando com Spring Boot";
    }
}
