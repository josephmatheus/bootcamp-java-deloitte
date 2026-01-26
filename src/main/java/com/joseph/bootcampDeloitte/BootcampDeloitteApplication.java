package com.joseph.bootcampDeloitte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BootcampDeloitteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampDeloitteApplication.class, args);

	}

    // Classe Produto
    public static class Produto {
        private Long id;
        private String nome;
        private Double preco;

        public Produto(Long id, String nome, Double preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }

        // Getters
        public Long getId() {
            return id;
        }
        public String getNome() {
            return nome;
        }
        public Double getPreco() {
            return preco;
        }

        // Setters
        public void setId(Long id) {
            this.id = id;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setPreco(Double preco) {
            this.preco = preco;
        }
    }

    // Cria array de produtos
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    // Rotas
    @RestController
    @RequestMapping("/api")

    public class ProdutoController {
        @GetMapping("/produtos")
        public Object rotaProdutos(){
            if(produtos.isEmpty()){
                return "Não há nenhum produto cadastrado";
            } else {
                return produtos;
            }
        }

        @GetMapping("/produtos/{id}")
        public Object rotaBuscaProdutosId(@PathVariable Long id){
            Long idProduto = id;
            for (Produto produto : produtos) {
                if (produto.getId().equals(idProduto)) {
                    return produto;
                } else {
                    return "Nenhum produto encontrado com este ID";
                }
            }
            return null;
        }

        @PostMapping("/produtos")
        public String cadastrarProduto(){
            Produto novoProduto = new Produto(1L, "Camisa Polo", 49.90);
            if (produtos.contains(novoProduto)) {
                return "Produto já cadastrado";
            } else {
                produtos.add(novoProduto);
                return "Produto cadastrado com sucesso";
            }
        }

        @DeleteMapping("/produtos/{id}")
        public String excluirProduto(@PathVariable Long id){
            Long idProduto = id;
            for (Produto produto : produtos) {
                if (produto.getId().equals(idProduto)) {
                    Produto produtoExcluido = produto;
                    produtos.remove(produtoExcluido);
                    return "Produto deletado com sucesso";
                } else {
                    return "Nenhum produto encontrado com este ID";
                }
            }
            return null;
        }

        @GetMapping("/hello")
        public String rotaHello(){
            return "API de Produtos rodando com Spring Boot";
        }
    }
}
