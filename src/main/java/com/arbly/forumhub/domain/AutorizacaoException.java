package com.arbly.forumhub.domain;

public class AutorizacaoException extends RuntimeException {
    public AutorizacaoException(String mensagem) {
        super(mensagem);
    }
}