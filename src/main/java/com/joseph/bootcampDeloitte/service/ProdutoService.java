package com.joseph.bootcampDeloitte.service;

import com.joseph.bootcampDeloitte.dto.ProdutoRequestDTO;
import com.joseph.bootcampDeloitte.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {

    List<ProdutoResponseDTO> listarProdutos();
    ProdutoResponseDTO buscarProdutoPorId(Long id);
    ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produto);
    ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO produto);

    void excluirProdutoPorId(Long id);
}
