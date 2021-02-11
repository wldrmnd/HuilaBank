package repo;

import entity.Transaction;

import java.util.List;

public class TransactionRepo {

    private List<Transaction> transactions;

    public TransactionRepo() {
    }

    public TransactionRepo(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public Transaction getTransactionById(Long id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        return null;
    }

    public List<Transaction> getAll() {
        return this.transactions;
    }

    public boolean removeById(Long id) {
        if (getTransactionById(id) != null) {
            this.transactions.remove(getTransactionById(id));
            return true;
        }
        return false;
    }
}
