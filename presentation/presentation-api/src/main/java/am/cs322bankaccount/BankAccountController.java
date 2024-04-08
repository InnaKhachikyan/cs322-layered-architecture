package am.cs322bankaccount;

import am.cs322bankaccount.model.*;

public interface BankAccountController {
    public BankAccountDTO createBankAccount(CreateBankAccountRequest request);

    public BankAccountDTO getBankAccount(Long id);//todo

    public double debit(Long id, DebitCreditRequest request);

    public double credit(Long id, DebitCreditRequest request);

}
