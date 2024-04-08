package am.cs322bankaccount;

import am.cs322bankaccount.model.*;
import am.cs322bankaccount.model.CreateBankAccountRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bank-accounts")
public class BankAccountControllerImpl implements BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountControllerImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    @PostMapping
    public BankAccountDTO createBankAccount(@RequestBody CreateBankAccountRequest request) {
        //System.out.println(request.toString());
        return bankAccountService.createBankAccount(request.userID());
    }

    @Override
    @GetMapping("/{id}")
    public BankAccountDTO getBankAccount(@PathVariable Long id){
        return bankAccountService.getBankAccount(id);
    }

    @Override
    @PostMapping("/{id}/debit")
    public double debit(@PathVariable Long id, @RequestBody DebitCreditRequest request) {
        BankAccountDTO bankAccount = bankAccountService.getBankAccount(id);
        return bankAccountService.debit(bankAccount.id(), request.amount());
    }

    @Override
    @PostMapping("/{id}/credit")
    public double credit(@PathVariable Long id, @RequestBody DebitCreditRequest request) {
        BankAccountDTO bankAccount = bankAccountService.getBankAccount(id);
        return bankAccountService.credit(bankAccount.id(), request.amount());
    }

}
