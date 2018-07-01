package club.cheapok.n26.repository.impl;

import club.cheapok.n26.model.Transaction;
import club.cheapok.n26.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(final Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void remove(final Transaction transaction) {
        transactions.remove(transaction);
    }

    @Override
    public List<Transaction> transactions() {
        return transactions;
    }

}
