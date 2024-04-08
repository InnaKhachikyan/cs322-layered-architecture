package am.cs322;

import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.BankAccountDTO;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/v1/bankAccounts")

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


}
