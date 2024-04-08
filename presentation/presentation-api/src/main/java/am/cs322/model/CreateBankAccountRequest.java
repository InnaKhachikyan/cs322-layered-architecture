package am.cs322.model;

import jakarta.annotation.Nonnull;

public record CreateBankAccountRequest(@Nonnull Long userID) {
}
