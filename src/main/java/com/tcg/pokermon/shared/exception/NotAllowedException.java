package com.tcg.pokermon.shared.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException() {
        super("You are not allowed to make that request");
    }
}
