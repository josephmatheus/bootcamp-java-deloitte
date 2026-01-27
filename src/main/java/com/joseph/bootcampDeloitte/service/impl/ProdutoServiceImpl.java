package com.joseph.bootcampDeloitte.service.impl;

import com.joseph.bootcampDeloitte.dto.ProdutoRequestDTO;
import com.joseph.bootcampDeloitte.dto.ProdutoResponseDTO;
import com.joseph.bootcampDeloitte.exception.ProdutoNaoEncontradoException;
import com.joseph.bootcampDeloitte.model.Produto;
import com.joseph.bootcampDeloitte.repository.ProdutoRepository;
import com.joseph.bootcampDeloitte.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoResponseDTO> listarProdutos(){
        return ((List<Produto>) produtoRepository.findAll())
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public ProdutoResponseDTO buscarProdutoPorId(Long id){
        return produtoRepository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    @Override
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto){
        Produto produto = toEntity(dto);
        Produto novoProduto = produtoRepository.save(produto);
        return  toResponseDTO(novoProduto);
    }

    @Override
    public ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto){
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(dto.getNome());
            produto.setPreco(dto.getPreco());
            Produto produtoAtualizado = produtoRepository.save(produto);
            return toResponseDTO(produtoAtualizado);
        }).orElse(null);
    }

    @Override
    public void excluirProdutoPorId(Long id){
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        produtoRepository.deleteById(id);
    }

    // Converter para Entity
    private Produto toEntity(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        return produto;
    }

    // Converter para DTO
    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        return dto;
    }
}
