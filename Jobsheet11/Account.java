import id.ac.polinema.InsufficientBalanceException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> history = new ArrayList<>();

    public List<Transaction> getHistory() {
        return history;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        history.add(new Transaction(TransactionType.DEPOSIT, amount));
        return true;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (!canWithdraw(amount)) {
            throw new InsufficientBalanceException(accountNumber + ": insufficient balance for a withdrawal of " + amount);
        }
        balance -= amount;
        history.add(new Transaction(TransactionType.WITHDRAW, amount))
    }
}