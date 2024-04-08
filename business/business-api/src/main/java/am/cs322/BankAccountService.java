package am.cs322;
import am.cs322.model.BankAccount;
import am.cs322.model.BankAccountDTO;

public interface BankAccountService {
    public BankAccountDTO createBankAccount(Long userID);

    public BankAccountDTO getBankAccount(Long bankAccountID);
    public double getBalance(Long id);

    public double debit(Long id, double amount);
    public double credit(Long id, double amount);
}
