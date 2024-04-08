package am.cs322;

import am.cs322.model.BankAccountDTO;
import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.UserDTO;

public interface BankAccountController {
    public BankAccountDTO createBankAccount(CreateBankAccountRequest request);

    public BankAccountDTO getBankAccount(Long id);//todo

}
