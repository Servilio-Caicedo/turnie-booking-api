package com.serviliocaicedo.turnie.auth;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Ya existe una cuenta con el correo " + email);
    }
}