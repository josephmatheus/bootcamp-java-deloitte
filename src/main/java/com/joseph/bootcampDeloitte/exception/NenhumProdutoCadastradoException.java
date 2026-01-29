package com.joseph.bootcampDeloitte.exception;

public class NenhumProdutoCadastradoException extends RuntimeException {
    public NenhumProdutoCadastradoException(){
        super("Nenhum produto cadastrado");
    }
}
