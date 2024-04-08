package am.cs322.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"bankAccount\"")

public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;
    private double balance;

    public BankAccount() { }

    public BankAccount(Long userID, double balance) {
        this.balance = balance;
        this.userID = userID;
    }

    //added by me
    public Long getID() {
        return id;
    }

    public Long getUserID() {
        return userID;
    }

    public double getBalance() {
        return balance;
    }

    public double debit(double amount) {
        balance += amount;
        return balance;
    }

    public double credit(double amount) {
        balance -= amount;
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount bankAccount = (BankAccount) o;
        return Objects.equals(id, bankAccount.id) && Objects.equals(userID, bankAccount.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

}
