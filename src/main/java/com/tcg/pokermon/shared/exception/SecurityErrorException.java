package com.tcg.pokermon.shared.exception;

public class SecurityErrorException extends RuntimeException {
    public SecurityErrorException() {
        super("Security error. Call a system administrator");
    }
}
