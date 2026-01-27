package com.joseph.bootcampDeloitte.controller;

import com.joseph.bootcampDeloitte.dto.ProdutoRequestDTO;
import com.joseph.bootcampDeloitte.dto.ProdutoResponseDTO;
import com.joseph.bootcampDeloitte.exception.ProdutoNaoEncontradoException;
import com.joseph.bootcampDeloitte.service.ProdutoService;
import org.springframework.http.ResponseEntity;
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
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            return "Não há nenhum produto cadastrado";
        }
        return produtos;
    }

    @GetMapping("/produtos/{id}")
    public Object buscarProduto(@PathVariable Long id) {
        ProdutoResponseDTO produto = produtoService.buscarProdutoPorId(id);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException(id);
        }
        return produto;
    }

    @PostMapping("/produtos")
    public ProdutoResponseDTO cadastrarProduto(@RequestBody ProdutoRequestDTO produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProdutoPorId(id);
        return ResponseEntity.ok("Produto excluido com sucesso!");
    }
    
    @PutMapping("/produtos/{id}")
    public ProdutoResponseDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {
        return produtoService.atualizarProdutoPorId(id, produto);
    }

    @GetMapping("/hello")
    public String hello() {
        return "API de Produtos rodando com Spring Boot";
    }
}
