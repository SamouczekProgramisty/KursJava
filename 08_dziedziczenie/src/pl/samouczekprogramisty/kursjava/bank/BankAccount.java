package pl.samouczekprogramisty.kursjava.bank;

import java.math.BigDecimal;

public interface BankAccount {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
}
