package Jobsheet11;
import java.util.Collection;

public interface AccountRepository {
    void save(Account account);
    Account findBynumvber(String accountNumber);
    Collection<Account> findAll();
}