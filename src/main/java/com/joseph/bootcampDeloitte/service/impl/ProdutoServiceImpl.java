package com.joseph.bootcampDeloitte.service.impl;

import com.joseph.bootcampDeloitte.dto.ProdutoRequestDTO;
import com.joseph.bootcampDeloitte.dto.ProdutoResponseDTO;
import com.joseph.bootcampDeloitte.exception.NenhumProdutoCadastradoException;
import com.joseph.bootcampDeloitte.exception.ProdutoDuplicadoException;
import com.joseph.bootcampDeloitte.exception.ProdutoNaoEncontradoException;
import com.joseph.bootcampDeloitte.mapper.ProdutoMapper;
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
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new NenhumProdutoCadastradoException();
        }
        return produtos.stream()
                .map(ProdutoMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProdutoResponseDTO buscarProdutoPorId(Long id){
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        return produtoRepository.findById(id)
                .map(ProdutoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto){
        if (produtoRepository.existsByNome(dto.getNome())){
            throw new ProdutoDuplicadoException(dto.getNome());
        }
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto novoProduto = produtoRepository.save(produto);
        return ProdutoMapper.toResponseDTO(novoProduto);
    }

    @Override
    public ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto){
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(dto.getNome());
            produto.setPreco(dto.getPreco());
            Produto produtoAtualizado = produtoRepository.save(produto);
            return ProdutoMapper.toResponseDTO(produtoAtualizado);
        }).orElse(null);
    }

    @Override
    public void excluirProdutoPorId(Long id){
        if(!produtoRepository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        produtoRepository.deleteById(id);
    }
}
