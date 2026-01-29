package com.joseph.bootcampDeloitte.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException(Long id){
        super("Nenhum produto encontrado com este ID: " + id);
    }
}
