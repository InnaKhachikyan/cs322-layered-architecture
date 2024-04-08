package am.cs322bankaccount.model;

import jakarta.annotation.Nonnull;

public record CreateBankAccountRequest(@Nonnull Long userID) {
}
