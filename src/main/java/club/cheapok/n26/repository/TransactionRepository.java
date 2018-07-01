package club.cheapok.n26.repository;

import club.cheapok.n26.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);

    void remove(Transaction transaction);

    List<Transaction> transactions();
}
