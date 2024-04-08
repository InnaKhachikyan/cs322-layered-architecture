package am.cs322bankaccount.model;

import jakarta.annotation.Nonnull;

public record DebitCreditRequest(@Nonnull double amount) {
}
