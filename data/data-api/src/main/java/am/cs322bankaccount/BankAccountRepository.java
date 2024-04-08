package am.cs322bankaccount;
import am.cs322bankaccount.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

}
