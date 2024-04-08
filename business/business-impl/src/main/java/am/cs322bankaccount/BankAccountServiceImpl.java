package am.cs322bankaccount;
import am.cs322bankaccount.model.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @Override
    public BankAccountDTO createBankAccount(Long userID) {
        BankAccount createdAccount = bankAccountRepository.save(new BankAccount(userID, 0));
        //System.out.println(createdUser.getID());
        return new BankAccountDTO(createdAccount.getID(), createdAccount.getUserID(), createdAccount.getBalance());
    }

    public double getBalance(Long id) {

        Optional<BankAccount> currentAccount = bankAccountRepository.findById(id);
        if(currentAccount.isPresent()) {
            BankAccount actualAccount = currentAccount.get();
            BankAccountDTO bankAccountDTO = new BankAccountDTO(actualAccount.getID(), actualAccount.getUserID(), actualAccount.getBalance());
            return bankAccountDTO.balance();
        }
        else {
            throw new RuntimeException("Bank account not found");
        }
    }

    public BankAccountDTO getBankAccount(Long id) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);

        if (bankAccount.isPresent()) {
            BankAccount actualAccount = bankAccount.get();
            return new BankAccountDTO(actualAccount.getID(), actualAccount.getUserID(), actualAccount.getBalance());
        } else {
            throw new RuntimeException("Bank account not found");
        }
    }

    public double debit(Long id, double amount) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if(bankAccount.isPresent()) {
            bankAccount.get().debit(amount);
            bankAccountRepository.save(bankAccount.get());
            return bankAccount.get().getBalance();
        }
        else {
            throw new RuntimeException("Bank account not found");
        }
    }

    public double credit(Long id, double amount) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if(bankAccount.isPresent()) {
            bankAccount.get().credit(amount);
            bankAccountRepository.save(bankAccount.get());
            return bankAccount.get().getBalance();
        }
        else {
            throw new RuntimeException("Bank account not found");
        }
    }

}
