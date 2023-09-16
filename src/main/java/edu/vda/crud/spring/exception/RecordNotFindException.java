package edu.vda.crud.spring.exception;

import java.io.Serial;

public class RecordNotFindException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public RecordNotFindException(Long id) {
        super("Registro não encontrado com o id: " + id);
    }
}
