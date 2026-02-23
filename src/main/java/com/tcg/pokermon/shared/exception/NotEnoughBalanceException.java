package com.tcg.pokermon.shared.exception;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException(Double required, Double balance) {
        super("Not enough balance. Required: $" + required + " / Your balance: $" + balance);
    }
}
