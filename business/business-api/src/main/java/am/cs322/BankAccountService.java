package am.cs322;
import am.cs322bankaccount.model.*;

public interface BankAccountService {
    public BankAccountDTO createBankAccount(Long userID);

    public BankAccountDTO getBankAccount(Long bankAccountID);
    public double getBalance(Long id);

    public double debit(Long id, double amount);
    public double credit(Long id, double amount);
}
